package com.globaltravel.globaltravel.repository.returnTypes;

public class UserCreationStatus {

    private boolean userCreationStatus;

    private String description;

    public UserCreationStatus() {
    }

    public boolean isUserCreationStatus() {
        return userCreationStatus;
    }

    public void setUserCreationStatus(boolean userCreationStatus) {
        this.userCreationStatus = userCreationStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
