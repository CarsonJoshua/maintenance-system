package com.example.MaintenanceSystem.service;

import com.example.MaintenanceSystem.model.TenantAccount;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ManagerService {
    private final String c = "tenants";
    public String validateFormSubmit(String tenantId) {
        return null;//TODO
    }

    public List<TenantAccount> getTenants() throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        List<TenantAccount> tenants = new ArrayList<>();
        for(DocumentReference tenantDoc : db.collection(c).listDocuments()){
            DocumentSnapshot tenantData = tenantDoc.get().get();
            if(tenantData.exists()){
//               System.out.println(soup);
                tenants.add(new TenantAccount(tenantData.getId(), tenantData.toObject(TenantAccount.TenantData.class)));
            }
        }
        return tenants;
    }
}
