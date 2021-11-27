package com.codeworm47.atmsimulator.bankservice.models.entities;

import java.util.Date;

public interface TimeStampCapable {
    Date getCreatedDate();
    void setCreatedDate(Date createdDate);

    Date getLastModifiedDate();
    void setLastModifiedDate(Date lastModifiedDate);
}
