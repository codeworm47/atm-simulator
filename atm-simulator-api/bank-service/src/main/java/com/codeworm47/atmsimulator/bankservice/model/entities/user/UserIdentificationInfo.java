package com.codeworm47.atmsimulator.bankservice.model.entities.user;

import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class UserIdentificationInfo {
    @NotEmpty
    private String type;
    @NotEmpty
    @Indexed(unique = true)
    private String value;
    private Date expiry;
    private String documentImage;

    public UserIdentificationInfo() {
    }

    public UserIdentificationInfo(String type, String value, Date expiry, String documentImage) {
        this.type = type;
        this.value = value;
        this.expiry = expiry;
        this.documentImage = documentImage;
    }

    public UserIdentificationInfo(String type, String value, Date expiry) {
        this.type = type;
        this.value = value;
        this.expiry = expiry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public String getDocumentImage() {
        return documentImage;
    }

    public void setDocumentImage(String documentImage) {
        this.documentImage = documentImage;
    }
}
