package com.smartclide.dbapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "service_registries")
@Data
public class ServiceRegistry {

    @Id
    private String id;

    private String user_id;

    //@DocumentReference
    //private User user;

    private String type;

    private String url;

    private String username;

    private String token;
}
