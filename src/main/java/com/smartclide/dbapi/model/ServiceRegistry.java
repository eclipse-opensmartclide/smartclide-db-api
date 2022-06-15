package com.smartclide.dbapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.validation.constraints.NotNull;

@Document(collection = "service_registries")
@Data
public class ServiceRegistry {

    @Id
    private String id;

    @NotNull
    private String user_id;

    //@DocumentReference
    //private User user;

    @NotNull
    private String type;

    @NotNull
    private String url;

    private String username;

    private String token;
}
