package com.example.MaintenanceSystem.model;

import com.google.cloud.Timestamp;

public class TenantAccount {
    private String id;
    private TenantData tenantData;
    public TenantAccount(String id, TenantData data) {
        this.id = id;
        this.tenantData = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getApartmentNumber() {
        return tenantData.getApartmentNumber();
    }

    public void setApartmentNumber(String apartmentNumber) {
        tenantData.apartmentNumber = apartmentNumber;
    }

    public Timestamp getCheckIn() {
        return tenantData.checkIn;
    }

    public void setCheckIn(Timestamp checkIn) {
        tenantData.checkIn = checkIn;
    }

    public Timestamp getCheckOut() {
        return tenantData.checkOut;
    }

    public void setCheckOut(Timestamp checkOut) {
        tenantData.checkOut = checkOut;
    }

    public String getEmail() {
        return tenantData.email;
    }

    public void setEmail(String email) {
        tenantData.email = email;
    }

    public String getName() {
        return tenantData.name;
    }

    public void setName(String name) {
        tenantData.name = name;
    }

    public String getPhoneNumber() {
        return tenantData.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        tenantData.phoneNumber = phoneNumber;
    }



}
