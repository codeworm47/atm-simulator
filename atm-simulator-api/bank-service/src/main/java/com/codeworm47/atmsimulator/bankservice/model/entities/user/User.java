package com.codeworm47.atmsimulator.bankservice.model.entities.user;

import com.codeworm47.atmsimulator.bankservice.model.entities.BaseEntity;
import com.codeworm47.atmsimulator.bankservice.model.entities.TimeStampCapable;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

public class User extends BaseEntity implements TimeStampCapable {

    private Date createdDate;
    private Date lastModifiedDate;

    @NotEmpty
    private String name;
    @NotEmpty
    private String lastName;
    private UserStatus status;
    private UserAuthenticationMechanism preferredAuthenticationMechanism;
    @NotEmpty
    private List<UserIdentificationInfo> identificationInfo;
    private List<UserBiometricInfo> biometricInfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public UserAuthenticationMechanism getPreferredAuthenticationMechanism() {
        return preferredAuthenticationMechanism;
    }

    public void setPreferredAuthenticationMechanism(UserAuthenticationMechanism preferredAuthenticationMechanism) {
        this.preferredAuthenticationMechanism = preferredAuthenticationMechanism;
    }

    public List<UserIdentificationInfo> getIdentificationInfo() {
        return identificationInfo;
    }

    public void setIdentificationInfo(List<UserIdentificationInfo> identificationInfo) {
        this.identificationInfo = identificationInfo;
    }

    public List<UserBiometricInfo> getBiometricInfo() {
        return biometricInfo;
    }

    public void setBiometricInfo(List<UserBiometricInfo> biometricInfo) {
        this.biometricInfo = biometricInfo;
    }

    public String getFullName(){
        return String.format("%s %s", this.name, this.lastName);
    }

    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    @Override
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
