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

@RestController
public class ServiceController {

    @Autowired
    private ServiceRepository repository;

    @GetMapping("/services")
    public List<Service> getAllServices() {
        return repository.findAll();
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

    @GetMapping("/services/createdAfter")
    public List<Service> getServicesCreatedAfterDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  Date date) {
        return repository.findByCreatedGreaterThan(date);
    }
}
