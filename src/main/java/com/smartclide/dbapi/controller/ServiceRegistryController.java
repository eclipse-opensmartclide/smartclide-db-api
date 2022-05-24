package com.smartclide.dbapi.controller;

import com.smartclide.dbapi.model.ServiceRegistry;
import com.smartclide.dbapi.repository.ServiceRegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ServiceRegistryController {

    @Autowired
    private ServiceRegistryRepository repository;

    @GetMapping("/service_registries")
    public List<ServiceRegistry> getAllServiceRegistries() {
        return repository.findAll();
    }

    @GetMapping("/service_registries/{id}")
    public Optional<ServiceRegistry> getServiceRegistry(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @PostMapping("/service_registries")
    public ResponseEntity<ServiceRegistry> creteServiceRegistry(@RequestBody ServiceRegistry serviceRegistry) {
        try {
            ServiceRegistry _serviceRegistry = repository.save(serviceRegistry);
            return new ResponseEntity<>(_serviceRegistry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/service_registries/{id}")
    public ResponseEntity<ServiceRegistry> updateServiceRegistry(@PathVariable("id") String id, @RequestBody ServiceRegistry serviceRegistry) {
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
