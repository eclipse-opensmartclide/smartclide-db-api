package com.smartclide.dbapi.controller;

import com.smartclide.dbapi.model.CiManager;
import com.smartclide.dbapi.repository.CiManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CiManagerController {

    @Autowired
    private CiManagerRepository repository;

    @GetMapping("/ci_managers")
    public List<CiManager> getAllCiManagers() {
        return repository.findAll();
    }

    @GetMapping("/ci_managers/{id}")
    public Optional<CiManager> getCiManager(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @PostMapping("/ci_managers")
    public ResponseEntity<CiManager> createCiManager(@RequestBody CiManager ciManager) {
        try {
            CiManager _ciManager = repository.save(ciManager);
            return new ResponseEntity<>(_ciManager, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/ci_managers/{id}")
    public ResponseEntity<CiManager> updateCiManager(@PathVariable("id") String id, @RequestBody CiManager ciManager) {
        try {
            Optional<CiManager> ciManagerData = repository.findById(id);

            if (ciManagerData.isPresent()) {
                CiManager _ciManager = ciManagerData.get();
                _ciManager.setUser_id(ciManager.getUser_id());
                _ciManager.setType(ciManager.getType());
                _ciManager.setUrl(ciManager.getUrl());
                _ciManager.setUsername(ciManager.getUsername());
                _ciManager.setToken(ciManager.getToken());

                return new ResponseEntity<>(repository.save(_ciManager), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/ci_managers/{id}")
    public ResponseEntity<?> deleteCiManager(@PathVariable("id") String id) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
