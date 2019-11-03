package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class UserPreferences {

    @JsonProperty("user_id")
    String userId;

    @JsonProperty("owns_a_car")
    Boolean ownsACar;

    @JsonProperty("tags")
    Tags tags;

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public Boolean getOwnsACar() {
        return ownsACar;
    }

    public void setOwnsACar(final Boolean ownsACar) {
        this.ownsACar = ownsACar;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(final Tags tags) {
        this.tags = tags;
    }
}
