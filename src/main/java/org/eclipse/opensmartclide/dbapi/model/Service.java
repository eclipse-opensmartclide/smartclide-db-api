package org.eclipse.opensmartclide.dbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "services")
@Data
public class Service {
    @Id
    private String id;

    @NotNull
    @TextIndexed
    private String name;

    @NotNull
    private String user_id;

    //@DBRef(lazy = true)
    //private User user;

    //@NotNull
    private String registry_id;

    private String workspace_id;

    //@DocumentReference
    //private ServiceRegistry serviceRegistry;

    private String  git_credentials_id;

    //@DocumentReference
    //private GitCredentials gitCredentials;

    private String url;

    //@NotNull
    @TextIndexed
    private String description;

    @NotNull
    @Field(value = "is_public")
    @JsonProperty(value = "is_public")
    private Boolean isPublic;

    private String licence;

    @Field
    private String framework = "None";

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    private Date created;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date updated;

    //@CreatedDate
    //@Field("test_date")
    //@JsonProperty("test_date")
    //private Date testDate;

    @NotNull
    private Boolean deployable;

    @Field
    private List<String> keywords = new ArrayList<>();

    //@NotNull
    //private String source;

    @Field
    private int stars = 0;

    @Field
    private int forks = 0;

    @Field
    private int watchers = 0;
}
