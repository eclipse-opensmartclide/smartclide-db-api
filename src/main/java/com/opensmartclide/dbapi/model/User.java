package com.opensmartclide.dbapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;

    @Email
    @NotNull(message = "email cannot be empty")
    private String email;

    //private Integer keycloak_id;

    private String team_id;

    //@DocumentReference(lazy = true, lookup = "{ 'user' : ?#{#self._id} }")
    //@ReadOnlyProperty
    //private Service user;

//    @DocumentReference()
//    private Team team;

    public User(String id) {
        this.id = id;
    }


}
