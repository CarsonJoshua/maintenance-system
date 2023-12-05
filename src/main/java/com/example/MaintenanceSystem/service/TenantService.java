package com.example.MaintenanceSystem.service;

import com.example.MaintenanceSystem.model.MaintenanceRequest;
import com.example.MaintenanceSystem.model.TenantAccount;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

import java.util.concurrent.ExecutionException;

public class TenantService {
    private String tenantId;
    private final String c = "tenants";

    public TenantService(String tenantId) {
        this.tenantId = tenantId;
    }
    public void createMaintenanceRequest(MaintenanceRequest.MaintenanceRequestData maintenanceRequestData){

    }
    public TenantAccount getTenant() throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentSnapshot doc = db.collection(c)
                .document(tenantId)
                .get().get();
        if(doc.exists()){
            return new TenantAccount(doc.getId(), doc.toObject(TenantAccount.TenantData.class));
        }
        return null;
    }
}
