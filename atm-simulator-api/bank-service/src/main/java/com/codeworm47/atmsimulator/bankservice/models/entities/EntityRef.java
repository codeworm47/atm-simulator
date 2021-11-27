package com.codeworm47.atmsimulator.bankservice.models.entities;

public class EntityRef {
    private String id;
    private String type;
    private String url;

    public EntityRef(String id, String type, String url) {
        this.id = id;
        this.type = type;
        this.url = url;
    }

    public EntityRef(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
