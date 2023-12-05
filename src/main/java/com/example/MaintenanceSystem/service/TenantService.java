package com.example.MaintenanceSystem.service;

import com.example.MaintenanceSystem.model.MaintenanceRequest;
import com.example.MaintenanceSystem.model.TenantAccount;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class TenantService {
    private String tenantId;
    private final String t = "tenants";
    private final String m = "maintenance-requests";

    public TenantService(String tenantId) {
        this.tenantId = tenantId;
    }
    public void createMaintenanceRequest(MaintenanceRequest.MaintenanceRequestData maintenanceRequestData){
        Firestore db = FirestoreClient.getFirestore();
        db.collection(m).document().set(maintenanceRequestData);
    }
    public TenantAccount getTenant() throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentSnapshot doc = db.collection(t)
                .document(tenantId)
                .get().get();
        if(doc.exists()){
            return new TenantAccount(doc.getId(), doc.toObject(TenantAccount.TenantData.class));
        }
        return null;
    }

    public String validateFormSubmit(String description, String problemArea) {
        return null;//TODO
    }
}
