package com.codeworm47.atmsimulator.bankservice.model.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BaseEntity {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
