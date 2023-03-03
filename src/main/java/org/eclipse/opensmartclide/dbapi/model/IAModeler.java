package org.eclipse.opensmartclide.dbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "models")
public class IAModeler {
    @Id
    private String id;

    @NotEmpty
    private String name;

    private String description;

    @NotEmpty
    private String user_creator_id;

    @NotEmpty
    private String category;

    @NotEmpty
    private String file_uri;

    @NotEmpty
    private String method;

    private String target;

    private Float size;

    @Field
    private List<String> labels = new ArrayList<>();

    @Field
    private List<String> extra = new ArrayList<>();

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
}
