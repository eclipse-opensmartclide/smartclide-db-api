package com.opensmartclide.dbapi.controller;

import com.opensmartclide.dbapi.model.Service;
import com.opensmartclide.dbapi.repository.ServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class ServiceController {

    @Autowired
    private ServiceRepository repository;

    @Autowired
    private MongoTemplate template;

    @GetMapping("/services")
    public List<Service> getAllServices(@RequestParam(value = "licence",required = false) String licence,
                                        @RequestParam(value = "framework",required = false) String framework,
                                        @RequestParam(value = "min_stars",required = false) String min_stars,
                                        @RequestParam(value = "max_stars",required = false) String max_stars,
                                        @RequestParam(value = "min_forks",required = false) String min_forks,
                                        @RequestParam(value = "max_forks",required = false) String max_forks,
                                        @RequestParam(value = "min_watchers",required = false) String min_watchers,
                                        @RequestParam(value = "max_watchers",required = false) String max_watchers,
                                        @RequestParam(value = "url",required = false) String url,
                                        @RequestParam(value = "deployable",required = false) String deployable,
                                        @RequestParam(value = "created_before",required = false) String created_before,
                                        @RequestParam(value = "created_after",required = false) String created_after,
                                        @RequestParam(value = "updated_before",required = false) String updated_before,
                                        @RequestParam(value = "updated_after",required = false) String updated_after,
                                        @RequestParam(value = "user_id",required = false) String userId,
                                        @RequestParam(value = "registry_id",required = false) String registryId,
                                        @RequestParam(value = "workspace_id",required = false) String workspaceId) throws ParseException {
        Query query = new Query();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

        if (licence != null) {
            query.addCriteria(Criteria.where("licence").is(licence));
        }
        if (framework != null) {
            query.addCriteria(Criteria.where("framework").is(framework));
        }

        if (min_stars != null && max_stars != null) {
            Criteria criteria = new Criteria();
            criteria.andOperator(Criteria.where("stars").gte(Integer.valueOf(min_stars)),Criteria.where("stars").lte(Integer.valueOf(max_stars)));
            query.addCriteria(criteria);
        }
        else if (min_stars != null && max_stars == null) {
            query.addCriteria(Criteria.where("stars").gte(Integer.valueOf(min_stars)));
        }
        else if (min_stars == null && max_stars != null) {
            query.addCriteria(Criteria.where("stars").lte(Integer.valueOf(max_stars)));
        }

        if (min_forks != null && max_forks != null) {
            Criteria criteria = new Criteria();
            criteria.andOperator(Criteria.where("forks").gte(min_forks),Criteria.where("forks").lte(max_forks));
            query.addCriteria(criteria);
        }
        else if (min_forks != null) {
            query.addCriteria(Criteria.where("forks").gte(min_forks));
        }
        else if (max_forks != null) {
            query.addCriteria(Criteria.where("forks").lte(max_forks));
        }

        if (min_watchers != null && max_watchers != null) {
            Criteria criteria = new Criteria();
            criteria.andOperator(Criteria.where("watchers").gte(min_watchers),Criteria.where("watchers").lte(max_watchers));
            query.addCriteria(criteria);
        }
        else if (min_watchers != null) {
            query.addCriteria(Criteria.where("watchers").gte(min_watchers));
        }
        else if (max_watchers != null) {
            query.addCriteria(Criteria.where("watchers").lte(max_watchers));
        }

        if (url != null) {
            query.addCriteria(Criteria.where("url").is(url));
        }
        if (deployable != null) {
            query.addCriteria(Criteria.where("deployable").is(Boolean.valueOf(deployable)));
        }

        if (created_before != null && created_after != null) {
            Criteria criteria = new Criteria();
            criteria.andOperator(Criteria.where("created").lte(dateFormat.parse(created_before)),Criteria.where("created").gte(dateFormat.parse(created_after)));
            query.addCriteria(criteria);
        }
        else if (created_before != null) {
            query.addCriteria(Criteria.where("created").lte(dateFormat.parse(created_before)));
        }
        else if (created_after != null) {
            query.addCriteria(Criteria.where("created").gte(dateFormat.parse(created_after)));
        }

        if (updated_before != null && updated_after != null) {
            Criteria criteria = new Criteria();
            criteria.andOperator(Criteria.where("updated").lte(dateFormat.parse(updated_before)),Criteria.where("updated").gte(dateFormat.parse(updated_after)));
            query.addCriteria(criteria);
        }
        else if (updated_before != null) {
            query.addCriteria(Criteria.where("updated").lte(dateFormat.parse(updated_before)));
        }
        else if (updated_after != null) {
            query.addCriteria(Criteria.where("updated").gte(dateFormat.parse(updated_after)));
        }
        if (userId != null) {
            query.addCriteria(Criteria.where("user_id").is(userId));
        }
        if (registryId != null) {
            query.addCriteria(Criteria.where("registry_id").is(registryId));
        }
        if (workspaceId != null) {
            query.addCriteria(Criteria.where("workspace_id").is(workspaceId));
        }

        return template.find(query, Service.class, "services");
    }

    @GetMapping("/services/{id}")
    public Optional<Service> getService(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @PostMapping("/services")
    public ResponseEntity<Service> createService(@RequestBody @Valid Service service) {
        if (service.getCreated() == null) {
            Date date = new Date();
            service.setCreated(date);
        }
        try {
            Service _service = repository.save(service);
            return new ResponseEntity<>(_service, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/services/bulk")
    public ResponseEntity<List<Service>> postServicesBulk(@RequestBody @Valid List<Service> services) {
        try {
            List<Service> _services = repository.saveAll(services);
            return new ResponseEntity<>(_services, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/services/{id}")
    public ResponseEntity<Service> updateService(@PathVariable("id") String id, @RequestBody @Valid Service service) {
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
                _service.setIsPublic(service.getIsPublic());
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
}
