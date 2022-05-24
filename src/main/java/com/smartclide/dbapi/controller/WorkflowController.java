package com.smartclide.dbapi.controller;

import com.smartclide.dbapi.model.Workflow;
import com.smartclide.dbapi.repository.WorkflowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WorkflowController {

    @Autowired
    private WorkflowRepository repository;

    @GetMapping("/workflows")
    public List<Workflow> getAllWorkflows() {
        return repository.findAll();
    }

    @GetMapping("/workflows/{id}")
    public Optional<Workflow> getWorkflow(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @PostMapping("/workflows")
    public ResponseEntity<Workflow> createWorkflow(@RequestBody Workflow workflow) {
        try {
            Workflow _workflow = repository.save(workflow);
            return new ResponseEntity<>(_workflow, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/workflows/{id}")
    public ResponseEntity<Workflow> updateWorkflow(@PathVariable("id") String id, @RequestBody Workflow workflow) {
        try {
            Optional<Workflow> workflowData = repository.findById(id);

            if (workflowData.isPresent()) {
                Workflow _workflow = workflowData.get();
                _workflow.setUser_id(workflow.getUser_id());
                _workflow.setGit_credentials_id(workflow.getGit_credentials_id());
                _workflow.setName(workflow.getName());
                _workflow.setUrl(workflow.getUrl());
                _workflow.setDescription(workflow.getDescription());
                _workflow.setIs_public(workflow.getIs_public());
                _workflow.setCreated(workflow.getCreated());
                _workflow.setUpdated(workflow.getUpdated());

                return new ResponseEntity<>(repository.save(_workflow), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/workflows/{id}")
    public ResponseEntity<?> deleteWorkflow(@PathVariable("id") String id) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
