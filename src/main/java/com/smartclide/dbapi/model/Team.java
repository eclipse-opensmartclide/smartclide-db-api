package com.smartclide.dbapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Document(collection = "teams")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @Id
    private String Id;

    @NotNull
    private String name;

    @Field
    private List<String> workflows = new ArrayList<>();

    @Field
    private List<String> services = new ArrayList<>();

    @Field
    private List<String> deployments = new ArrayList<>();

//    @DocumentReference
//    private List<Workflow> workflows;
//
//    @DocumentReference
//    private List<Service> services;
//
//    @DocumentReference
//    private List<Deployment> deployments;

    public Team(String id) {
        Id = id;
    }
}
