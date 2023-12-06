package com.example.MaintenanceSystem.model;

import com.google.cloud.Timestamp;

public class MaintenanceRequestData{
    protected String apartmentNumber;
    protected String description;
    protected String problemArea;
    protected String status;
    protected Timestamp time;
    public MaintenanceRequestData(String apartmentNumber, String description, String problemArea, String status, Timestamp time) {
        this.apartmentNumber = apartmentNumber;
        this.description = description;
        this.problemArea = problemArea;
        this.status = status;
        this.time = time;
    }

    public MaintenanceRequestData(String apartmentNumber, String description, String problemArea, String status) {
        this(apartmentNumber, description, problemArea, status, Timestamp.now());
    }
    public MaintenanceRequestData(){
        this("0000", "Error loading entry from the database", "Database Error","pending");
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
