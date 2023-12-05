package com.example.MaintenanceSystem.model;

import com.google.cloud.Timestamp;

public class MaintenanceRequest {
    private String id;
    private MaintenanceRequestData maintenanceRequestData;

    public MaintenanceRequest(String id, MaintenanceRequestData maintenanceRequestData) {
        this.id = id;
        this.maintenanceRequestData = maintenanceRequestData;
    }

    public static class MaintenanceRequestData{
        private String apartmentNumber;
        private String description;
        private String problemArea;
        private String status;
        private Timestamp time;

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
}
