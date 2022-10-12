package org.eclipse.opensmartclide.dbapi.controller;

import org.eclipse.opensmartclide.dbapi.model.ServiceRegistry;
import org.eclipse.opensmartclide.dbapi.repository.ServiceRegistryRepository;
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
public class ServiceRegistryController {

    @Autowired
    private ServiceRegistryRepository repository;

    @Autowired
    private MongoTemplate template;

    @GetMapping("/service_registries")
    public List<ServiceRegistry> getAllServiceRegistries(@RequestParam(value = "user_id",required = false) String userId) {
        Query query = new Query();
        if (userId != null) {
            query.addCriteria(Criteria.where("user_id").is(userId));
        }
        return template.find(query, ServiceRegistry.class, "service_registries");
        //return repository.findAll();
    }

    @GetMapping("/service_registries/{id}")
    public Optional<ServiceRegistry> getServiceRegistry(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @PostMapping("/service_registries")
    public ResponseEntity<ServiceRegistry> creteServiceRegistry(@RequestBody @Valid ServiceRegistry serviceRegistry) {
        try {
            ServiceRegistry _serviceRegistry = repository.save(serviceRegistry);
            return new ResponseEntity<>(_serviceRegistry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/service_registries/{id}")
    public ResponseEntity<ServiceRegistry> updateServiceRegistry(@PathVariable("id") String id, @RequestBody @Valid ServiceRegistry serviceRegistry) {
        try {
            Optional<ServiceRegistry> serviceRegistryData = repository.findById(id);

            if (serviceRegistryData.isPresent()) {
                ServiceRegistry _serviceRegistry = serviceRegistryData.get();

                _serviceRegistry.setUser_id(serviceRegistry.getUser_id());
                _serviceRegistry.setType(serviceRegistry.getType());
                _serviceRegistry.setUrl(serviceRegistry.getUrl());
                _serviceRegistry.setUsername(serviceRegistry.getUsername());
                _serviceRegistry.setToken(serviceRegistry.getToken());

                return new ResponseEntity<>(repository.save(_serviceRegistry), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/service_registries/{id}")
    public ResponseEntity<?> deleteServiceRegistry(@PathVariable("id") String id) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
