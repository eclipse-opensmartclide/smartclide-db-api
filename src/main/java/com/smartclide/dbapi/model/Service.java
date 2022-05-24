package com.smartclide.dbapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "services")
@Data
public class Service {
    @Id
    private String id;

    private String name;

    private String user_id;

    //@DocumentReference
    //private User user;

    private String registry_id;

    //@DocumentReference
    //private ServiceRegistry serviceRegistry;

    private String  git_credentials_id;

    //@DocumentReference
    //private GitCredentials gitCredentials;

    private String url;

    private String description;

    private Boolean is_public;

    private String licence;

    private String framework;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date created;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date updated;
}
