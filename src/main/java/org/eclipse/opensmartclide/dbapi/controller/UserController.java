package org.eclipse.opensmartclide.dbapi.controller;

import org.eclipse.opensmartclide.dbapi.model.User;
import org.eclipse.opensmartclide.dbapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        try {
            User _user = repository.save(user);
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody @Valid User user) {
        try {
            Optional<User> userData = repository.findById(id);
            if (userData.isPresent()) {
                User _user = userData.get();
                _user.setEmail(user.getEmail());
                //_user.setKeycloak_id(user.getKeycloak_id());
                _user.setTeam_id(user.getTeam_id());

                return new ResponseEntity<>(repository.save(_user), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
