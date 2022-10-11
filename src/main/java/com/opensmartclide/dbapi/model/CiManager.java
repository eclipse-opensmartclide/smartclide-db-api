package com.opensmartclide.dbapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.validation.constraints.NotNull;

@Document(collection = "ci_managers")
@Data
public class CiManager {

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

    @NotNull
    private String username;

    //@NotNull
    private String token;
}
