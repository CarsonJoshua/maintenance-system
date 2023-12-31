package com.example.MaintenanceSystem.model;

import com.google.cloud.Timestamp;

public class MaintenanceRequest {
    private String id;
    private String apartmentNumber;
    private String description;
    private String problemArea;
    private String status;
    private Timestamp time;

    public MaintenanceRequest(String id, MaintenanceRequestData maintenanceRequestData) {
        this.id = id;
        this.apartmentNumber = maintenanceRequestData.apartmentNumber;
        this.description = maintenanceRequestData.description;
        this.problemArea = maintenanceRequestData.problemArea;
        this.status = maintenanceRequestData.status;
        this.time = maintenanceRequestData.time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProblemArea() {
        return problemArea;
    }

    public void setProblemArea(String problemArea) {
        this.problemArea = problemArea;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
