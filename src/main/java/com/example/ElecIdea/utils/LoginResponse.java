
package com.example.ElecIdea.utils;

public class LoginResponse extends ResponseMessage {
    private String userId;

    public LoginResponse(String status, String message, String userId) {
        super(status, message); 
        this.userId = userId;
    }

    // Getter y setter para el userId
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}