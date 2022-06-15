package com.smartclide.dbapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Document(collection = "deployments")
@Data
public class Deployment {

    @Id
    private String id;

    @NotNull
    private String user_id;

    //@DocumentReference
    //private User user;

    @NotNull
    private String git_credentials_id;

    //@DocumentReference
    //private GitCredentials gitCredentials;

    @NotNull
    private String name;

    @NotNull
    private String url;

    @NotNull
    private String workflow_id;

    //@DocumentReference
    //private Workflow workflow;

    @NotNull
    private String service_id;

    //@DocumentReference
    //private Service service;

    @NotNull
    private String version;

    @NotNull
    private String state;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date created;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date updated;
}
