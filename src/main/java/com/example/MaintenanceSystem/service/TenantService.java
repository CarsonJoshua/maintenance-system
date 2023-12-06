package com.example.MaintenanceSystem.service;

import com.example.MaintenanceSystem.model.MaintenanceRequest;
import com.example.MaintenanceSystem.model.MaintenanceRequestData;
import com.example.MaintenanceSystem.model.TenantAccount;
import com.example.MaintenanceSystem.model.TenantData;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class TenantService {
    private final String t = "tenants";
    private final String m = "maintenance-requests";

    public void createMaintenanceRequest(MaintenanceRequestData maintenanceRequestData){
        Firestore db = FirestoreClient.getFirestore();
        db.collection(m).document().set(maintenanceRequestData);
    }
    public TenantAccount getTenant(String tenantId) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentSnapshot doc = db.collection(t)
                .document(tenantId)
                .get().get();
        if(doc.exists()){
//            System.out.println(doc);
            return new TenantAccount(doc.getId(), doc.toObject(TenantData.class));
        }
        return null;
    }

    public String validateFormSubmit(String description, String problemArea) {
        return null;//TODO
    }
}
