package com.example.demo.model;

import java.util.Date;


public class TaskRequest {

    RequestCategoryEnum requestCategory;
    String subcategory;
    String timeStampForEvent;
    String creationTime;
    String purposeOfRequest;
    String descriptionOfRequest;
    String eventCoordinates;
    String addressLine1;
    String addressLine2;
    String city;
    String State;
    String Country;
    String zipCode;
    String requestorId;
    String requestorName;

    public RequestCategoryEnum getRequestCategory() {
        return requestCategory;
    }

    public void setRequestCategory(final RequestCategoryEnum requestCategory) {
        this.requestCategory = requestCategory;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(final String subcategory) {
        this.subcategory = subcategory;
    }

    public String getTimeStampForEvent() {
        return timeStampForEvent;
    }

    public void setTimeStampForEvent(final String timeStampForEvent) {
        this.timeStampForEvent = timeStampForEvent;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(final String creationTime) {
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

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(final String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(final String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getState() {
        return State;
    }

    public void setState(final String state) {
        State = state;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(final String country) {
        Country = country;
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

    public String getRequestorName() {
        return requestorName;
    }

    public void setRequestorName(final String requestorName) {
        this.requestorName = requestorName;
    }

}
