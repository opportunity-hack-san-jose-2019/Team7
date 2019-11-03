package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class TaskFilter {

    @JsonProperty("category")
    String requestCategory;

    @JsonProperty("subcategory")
    String subcategory;

    @JsonProperty("requestor_id")
    String requestorId;

    @JsonProperty("volunteer_id")
    String volunteerId;

    @JsonProperty("is_finished")
    Boolean isFinished;

    public String getRequestCategory() {
        return requestCategory;
    }

    public void setRequestCategory(final String requestCategory) {
        this.requestCategory = requestCategory;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(final String subcategory) {
        this.subcategory = subcategory;
    }

    public String getRequestorId() {
        return requestorId;
    }

    public void setRequestorId(final String requestorId) {
        this.requestorId = requestorId;
    }

    public String getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(final String volunteerId) {
        this.volunteerId = volunteerId;
    }

    public Boolean isFinished() {
        return isFinished;
    }

    public void setFinished(final Boolean finished) {
        isFinished = finished;
    }
}
