package org.eclipse.opensmartclide.dbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Document(collection = "deployments")
@Data
public class Deployment {

    @Id
    private String id;

    @NotEmpty
    private String user_id;

    @NotEmpty
    private String user;

    //@DocumentReference
    //private User user;

    @NotEmpty
    private String git_credentials_id;

    //@DocumentReference
    //private GitCredentials gitCredentials;

    @NotEmpty
    private String name;

    @NotEmpty
    private String project;

    //@NotNull
    //private String url;

    @NotEmpty
    private String service_url;

    @NotEmpty
    private String k8s_url;

    @NotEmpty
    private Integer port;

    private Integer replicas;

    @NotEmpty
    private String workflow_id;

    //@DocumentReference
    //private Workflow workflow;

    @NotEmpty
    private String service_id;

    //@DocumentReference
    //private Service service;

    private String version;

    @NotEmpty
    private String state;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Field("created_at")
    @JsonProperty("created_at")
    @CreatedDate
    private Date created;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Field("updated_at")
    @JsonProperty("updated_at")
    @LastModifiedDate
    private Date updated;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Field("stopped_at")
    @JsonProperty("stopped_at")
    private Date stopped;
}
