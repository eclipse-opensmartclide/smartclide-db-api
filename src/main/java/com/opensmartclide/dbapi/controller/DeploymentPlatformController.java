package com.opensmartclide.dbapi.controller;

import com.opensmartclide.dbapi.model.DeploymentPlatform;
import com.opensmartclide.dbapi.repository.DeploymentPlatformRepository;

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
public class DeploymentPlatformController {

    @Autowired
    private DeploymentPlatformRepository repository;

    @Autowired
    private MongoTemplate template;

    @GetMapping("/deployment_platforms")
    public List<DeploymentPlatform> getAllDeploymentPlatforms(@RequestParam(value = "user_id",required = false) String userId) {
        Query query = new Query();
        if (userId != null) {
            query.addCriteria(Criteria.where("user_id").is(userId));
        }
        return template.find(query, DeploymentPlatform.class, "deployment_platforms");
        //return repository.findAll();
    }

    @GetMapping("/deployment_platforms/{id}")
    public Optional<DeploymentPlatform> getDeploymentPlatform(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @PostMapping("deployment_platforms")
    public ResponseEntity<DeploymentPlatform> createDeploymentPlatform(@RequestBody @Valid DeploymentPlatform deploymentPlatform) {
        try {
            DeploymentPlatform _deploymentPlatform = repository.save(deploymentPlatform);
            return new ResponseEntity<>(_deploymentPlatform, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/deployment_platforms/{id}")
    public ResponseEntity<DeploymentPlatform> updateDeploymentPlatform(@PathVariable("id") String id, @RequestBody @Valid DeploymentPlatform deploymentPlatform) {
        try {
            Optional<DeploymentPlatform> deploymentPlatformData = repository.findById(id);

            if (deploymentPlatformData.isPresent()) {
                DeploymentPlatform _deploymentPlatform = deploymentPlatformData.get();

                _deploymentPlatform.setUser_id(deploymentPlatform.getUser_id());
                _deploymentPlatform.setUrl(deploymentPlatform.getUrl());
                _deploymentPlatform.setUsername(deploymentPlatform.getUsername());
                _deploymentPlatform.setToken(deploymentPlatform.getToken());

                return new ResponseEntity<>(repository.save(_deploymentPlatform), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deployment_platforms/{id}")
    public ResponseEntity<?> deleteDeploymentPlatform(@PathVariable("id") String id) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
