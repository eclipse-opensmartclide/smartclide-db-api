package org.eclipse.opensmartclide.dbapi.controller;

import org.eclipse.opensmartclide.dbapi.model.Deployment;
import org.eclipse.opensmartclide.dbapi.repository.DeploymentRepository;
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
                                              @RequestParam(value = "workflow_id",required = false) String workflowId,
                                              @RequestParam(value = "user",required = false) String user,
                                              @RequestParam(value = "service_url",required = false) String service_url,
                                              @RequestParam(value = "project",required = false) String project) {
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
        if (user != null) {
            query.addCriteria(Criteria.where("user").is(user));
        }
        if (service_url != null) {
            query.addCriteria(Criteria.where("service_url").is(service_url));
        }
        if (project != null) {
            query.addCriteria(Criteria.where("project").is(project));
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
            Deployment db_deployment = repository.save(deployment);
            return new ResponseEntity<>(db_deployment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/deployments/{id}")
    public ResponseEntity<Deployment> updateDeployment(@PathVariable("id") String id, @RequestBody @Valid Deployment deployment) {
        try {
            Optional<Deployment> deploymentData = repository.findById(id);

            if (deploymentData.isPresent()) {
                Deployment db_deployment = deploymentData.get();
                db_deployment.setUser_id(deployment.getUser_id());
                db_deployment.setUser(deployment.getUser());
                db_deployment.setGit_credentials_id(deployment.getGit_credentials_id());
                db_deployment.setName(deployment.getName());
                //db_deployment.setUrl(deployment.getUrl());
                db_deployment.setService_url(deployment.getService_url());
                db_deployment.setProject(deployment.getProject());
                db_deployment.setPort(deployment.getPort());
                db_deployment.setReplicas(deployment.getReplicas());
                db_deployment.setK8s_url(deployment.getK8s_url());
                db_deployment.setWorkflow_id(deployment.getWorkflow_id());
                db_deployment.setService_id(deployment.getService_id());
                db_deployment.setVersion(deployment.getVersion());
                db_deployment.setState(deployment.getState());
                db_deployment.setCreated(deployment.getCreated());
                //db_deployment.setUpdated(deployment.getUpdated());
                db_deployment.setStopped(deployment.getStopped());

                return new ResponseEntity<>(repository.save(db_deployment), HttpStatus.OK);
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
