package com.smartclide.dbapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "deployments")
@Data
public class Deployment {

    @Id
    private String id;

    private String user_id;

    //@DocumentReference
    //private User user;

    private String git_credentials_id;

    //@DocumentReference
    //private GitCredentials gitCredentials;

    private String name;

    private String url;

    private String workflow_id;

    //@DocumentReference
    //private Workflow workflow;

    private String service_id;

    //@DocumentReference
    //private Service service;

    private String version;

    private String state;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date created;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date updated;
}
