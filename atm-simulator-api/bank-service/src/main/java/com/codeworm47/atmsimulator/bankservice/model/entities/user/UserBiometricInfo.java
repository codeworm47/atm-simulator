package com.codeworm47.atmsimulator.bankservice.model.entities.user;

public class UserBiometricInfo {

    private String type;
    private String  hashedData;
    private String  externalLink;
    private String  filePath;

    public UserBiometricInfo(String type, String hashedData, String filePath, String externalLink) {
        this(type, hashedData, filePath);
        this.externalLink = externalLink;
    }

    public UserBiometricInfo(String type, String hashedData, String filePath) {
        this(type, hashedData);
        this.filePath = filePath;
    }

    public UserBiometricInfo(String type, String hashedData) {
        this.type = type;
        this.hashedData = hashedData;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHashedData() {
        return hashedData;
    }

    public void setHashedData(String hashedData) {
        this.hashedData = hashedData;
    }

    public String getExternalLink() {
        return externalLink;
    }

    public void setExternalLink(String externalLink) {
        this.externalLink = externalLink;
    }
}
