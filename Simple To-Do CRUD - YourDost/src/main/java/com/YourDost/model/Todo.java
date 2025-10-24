package com.YourDost.model;

import lombok.Data;
import org.springframework.data.mongodb.core.annotation.Collation;

@Data
@Collation("Todo")
public class Todo {

    private String id;
    private String title;
    private String description;
    private boolean completed;
}

