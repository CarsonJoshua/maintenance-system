package com.example.MaintenanceSystem.service;

import com.example.MaintenanceSystem.model.MaintenanceRequest;
import com.example.MaintenanceSystem.model.TenantAccount;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ManagerService {
    private final String c = "tenants";
    public String validateFormSubmit(String tenantId) {
        return null;//TODO
    }

    public List<TenantAccount> getTenants() throws ExecutionException, InterruptedException {//todo this gets everything, but I really just need the names and ids for listing initially
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

    public TenantAccount getTenantById(String tenantId) throws ExecutionException, InterruptedException {
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
