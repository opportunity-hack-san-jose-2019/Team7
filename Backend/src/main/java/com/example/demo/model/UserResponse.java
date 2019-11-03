package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class UserResponse {

    @JsonProperty("user_id")
    String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }
}
