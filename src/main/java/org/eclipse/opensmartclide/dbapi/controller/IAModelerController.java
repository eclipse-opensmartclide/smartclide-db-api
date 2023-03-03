package org.eclipse.opensmartclide.dbapi.controller;

import org.eclipse.opensmartclide.dbapi.model.IAModeler;
import org.eclipse.opensmartclide.dbapi.repository.IAModelerRepository;
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
public class IAModelerController {
    @Autowired
    private IAModelerRepository repository;

    @Autowired
    private MongoTemplate template;

    @GetMapping("/models")
    public List<IAModeler> getAllModels(@RequestParam(value = "user_id",required = false) String userId) {
        Query query = new Query();
        if (userId != null) {
            query.addCriteria(Criteria.where("user_creator_id").is(userId));
        }

        return template.find(query, IAModeler.class, "models");
    }

    @GetMapping("/models/{id}")
    public Optional<IAModeler> getModel(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @PostMapping("/models")
    public ResponseEntity<IAModeler> createModel(@RequestBody @Valid IAModeler model) {
        try {
            IAModeler db_model = repository.save(model);
            return new ResponseEntity<>(db_model, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/models/{id}")
    public ResponseEntity<IAModeler> updateModel(@PathVariable("id") String id, @RequestBody @Valid IAModeler model) {
        try {
            Optional<IAModeler> modelData = repository.findById(id);

            if (modelData.isPresent()) {
                IAModeler db_model = modelData.get();
                db_model.setUser_creator_id(model.getUser_creator_id());
                db_model.setName(model.getName());
                db_model.setDescription(model.getDescription());
                db_model.setCategory(model.getCategory());
                db_model.setExtra(model.getExtra());
                db_model.setFile_uri(model.getFile_uri());
                db_model.setLabels(model.getLabels());
                db_model.setMethod(model.getMethod());
                db_model.setTarget(model.getTarget());
                db_model.setSize(model.getSize());

                return new ResponseEntity<>(repository.save(db_model), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/models/{id}")
    public ResponseEntity<?> deleteModel(@PathVariable("id") String id) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
