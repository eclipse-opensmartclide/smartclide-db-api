package com.smartclide.dbapi.controller;

import com.smartclide.dbapi.model.Deployment;
import com.smartclide.dbapi.repository.DeploymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class DeploymentController {

    @Autowired
    private DeploymentRepository repository;

    @Autowired
    private MongoTemplate template;

    @GetMapping("/deployments")
    public List<Deployment> getAllDeployments(@RequestParam(value = "user_id",required = false) String userId,
                                              @RequestParam(value = "service_id",required = false) String serviceId,
                                              @RequestParam(value = "workflow_id",required = false) String workflowId) {
        Query query = new Query();
        if (userId != null) {
            query.addCriteria(Criteria.where("user_id").is(userId));
        }
        if (serviceId != null) {
            query.addCriteria(Criteria.where("service_id").is(serviceId));
        }
        if (workflowId != null) {
            query.addCriteria(Criteria.where("workflow_id").is(workflowId));
        }
        return template.find(query, Deployment.class, "deployments");
        //return repository.findAll();
    }

    @GetMapping("/deployments/{id}")
    public Optional<Deployment> getDeployment(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @PostMapping("/deployments")
    public ResponseEntity<Deployment> createDeployment(@RequestBody @Valid Deployment deployment) {
        try {
            Deployment _deployment = repository.save(deployment);
            return new ResponseEntity<>(_deployment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/deployments/{id}")
    public ResponseEntity<Deployment> updateDeployment(@PathVariable("id") String id, @RequestBody @Valid Deployment deployment) {
        try {
            Optional<Deployment> deploymentData = repository.findById(id);

            if (deploymentData.isPresent()) {
                Deployment _deployment = deploymentData.get();
                _deployment.setUser_id(deployment.getUser_id());
                _deployment.setGit_credentials_id(deployment.getGit_credentials_id());
                _deployment.setName(deployment.getName());
                _deployment.setUrl(deployment.getUrl());
                _deployment.setWorkflow_id(deployment.getWorkflow_id());
                _deployment.setService_id(deployment.getService_id());
                _deployment.setVersion(deployment.getVersion());
                _deployment.setState(deployment.getState());
                _deployment.setCreated(deployment.getCreated());
                _deployment.setUpdated(deployment.getUpdated());

                return new ResponseEntity<>(repository.save(_deployment), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deployments/{id}")
    public ResponseEntity<?> deleteDeployment(@PathVariable("id") String id) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
