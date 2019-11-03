package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Task {

    @JsonProperty("task_id")
    String taskId;

    @JsonProperty("category")
    String requestCategory;

    @JsonProperty("subcategory")
    String subcategory;

    @JsonProperty("event_time")
    long timeStampForEvent;

    @JsonProperty("creation_time")
    long creationTime;

    @JsonProperty("purpose")
    String purposeOfRequest;

    @JsonProperty("details")
    String descriptionOfRequest;

    @JsonProperty("coordinates")
    String eventCoordinates;

    @JsonProperty("address")
    String address;

    @JsonProperty("city")
    String city;

    @JsonProperty("state")
    String state;

    @JsonProperty("country")
    String country;

    @JsonProperty("zipcode")
    String zipCode;

    @JsonProperty("requestor_id")
    String requestorId;

    @JsonProperty("volunteer_id")
    String volunteerId;

    @JsonProperty("priority")
    int priority; // higher the number, more the priority.

    @JsonProperty("is_finished")
    boolean isFinished;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(final String taskId) {
        this.taskId = taskId;
    }

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

     public long getTimeStampForEvent() {
        return timeStampForEvent;
    }

     public void setTimeStampForEvent(final long timeStampForEvent) {
        this.timeStampForEvent = timeStampForEvent;
    }

     public long getCreationTime() {
        return creationTime;
    }

     public void setCreationTime(final long creationTime) {
        this.creationTime = creationTime;
    }

     public String getPurposeOfRequest() {
        return purposeOfRequest;
    }

     public void setPurposeOfRequest(final String purposeOfRequest) {
        this.purposeOfRequest = purposeOfRequest;
    }

     public String getDescriptionOfRequest() {
        return descriptionOfRequest;
    }

     public void setDescriptionOfRequest(final String descriptionOfRequest) {
        this.descriptionOfRequest = descriptionOfRequest;
    }

     public String getEventCoordinates() {
        return eventCoordinates;
    }

     public void setEventCoordinates(final String eventCoordinates) {
        this.eventCoordinates = eventCoordinates;
    }

     public String getAddress() {
        return address;
    }

     public void setAddress(final String address) {
        this.address = address;
    }

     public String getCity() {
        return city;
    }

     public void setCity(final String city) {
        this.city = city;
    }

     public String getState() {
        return state;
    }

     public void setState(final String state) {
        this.state = state;
    }

     public String getCountry() {
        return country;
    }

     public void setCountry(final String country) {
        this.country = country;
    }

     public String getZipCode() {
        return zipCode;
    }

     public void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(final int priority) {
        this.priority = priority;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(final boolean finished) {
        isFinished = finished;
    }
}
