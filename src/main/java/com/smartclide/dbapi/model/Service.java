package com.smartclide.dbapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "services")
@Data
public class Service {
    @Id
    private String id;

    private String name;

    private Date created;
}
