package com.smartclide.dbapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "git_credentials")
@Data
public class GitCredentials {

    @Id
    private String id;

    private String user_id;

    //@ReadOnlyProperty
    //@DocumentReference(lookup = "{ 'user' : ?#{#self._id} }")
    //@DocumentReference
    //@DBRef
    //private User user;

    private String type;

    private String url;

    private String username;

    private String token;
}
