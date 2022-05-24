package com.smartclide.dbapi.controller;

import com.smartclide.dbapi.model.Service;
import com.smartclide.dbapi.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class ServiceController {

    @Autowired
    private ServiceRepository repository;

    @GetMapping("/services")
    public List<Service> getAllServices() {
        return repository.findAll();
    }

    @GetMapping("/services/{id}")
    public Optional<Service> getService(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @PostMapping("/services")
    public ResponseEntity<Service> createService(@RequestBody Service service) {
        try {
            Service _service = repository.save(service);
            return new ResponseEntity<>(_service, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/services/{id}")
    public ResponseEntity<Service> updateService(@PathVariable("id") String id, @RequestBody Service service) {
        try {
            Optional<Service> serviceData = repository.findById(id);

            if (serviceData.isPresent()) {
                Service _service = serviceData.get();
                _service.setName(service.getName());
                _service.setUser_id(service.getUser_id());
                _service.setRegistry_id(service.getRegistry_id());
                _service.setGit_credentials_id(service.getGit_credentials_id());
                service.setUrl(service.getUrl());
                _service.setDescription(service.getDescription());
                _service.setIs_public(service.getIs_public());
                _service.setLicence(service.getLicence());
                _service.setFramework(service.getFramework());
                _service.setCreated(service.getCreated());
                _service.setUpdated(service.getUpdated());

                return new ResponseEntity<>(repository.save(_service), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/services/{id}")
    public ResponseEntity<?> deleteService(@PathVariable("id") String id) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/services/createdAfter")
    public List<Service> getServicesCreatedAfterDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  Date date) {
        return repository.findByCreatedGreaterThan(date);
    }
}
