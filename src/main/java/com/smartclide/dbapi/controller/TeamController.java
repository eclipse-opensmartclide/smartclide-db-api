package com.smartclide.dbapi.controller;

import com.smartclide.dbapi.model.Team;
import com.smartclide.dbapi.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class TeamController {

    @Autowired
    private TeamRepository repository;

    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        return repository.findAll();
    }

    @GetMapping("/teams/{id}")
    public Optional<Team> getTeam(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @PostMapping("/teams")
    public ResponseEntity<Team> createTeam(@RequestBody @Valid Team team) {
        try {
            Team _team = repository.save(team);
            return new ResponseEntity<>(_team, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/teams/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable("id") String id, @RequestBody @Valid Team team) {
        try {
            Optional<Team> teamData = repository.findById(id);

            if (teamData.isPresent()) {
                Team _team = teamData.get();
                _team.setName(team.getName());
                _team.setWorkflows(team.getWorkflows());
                _team.setServices(team.getServices());
                _team.setDeployments(team.getDeployments());

                return new ResponseEntity<>(repository.save(_team), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/teams/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable("id") String id) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
