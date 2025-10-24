package com.YourDost.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Collation("todo")
public class Todo {

    String id;
    private String title;
    private String description;
    private boolean completed;
}
