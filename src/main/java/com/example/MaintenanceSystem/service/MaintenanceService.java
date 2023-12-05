package com.example.MaintenanceSystem.service;

import com.example.MaintenanceSystem.model.MaintenanceRequest;
import com.example.MaintenanceSystem.model.TenantAccount;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MaintenanceService {
    private final String c = "maintenance-requests";
    public String validateFormSubmit(String requestId) {
        return null;//TODO
    }

    public List<MaintenanceRequest> getMaintenanceRequests() throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        List<MaintenanceRequest> maintenanceRequests = new ArrayList<>();
        for(DocumentReference maintenanceDoc : db.collection(c).listDocuments()){
            DocumentSnapshot maintenanceData = maintenanceDoc.get().get();
            if(maintenanceData.exists()){
//               System.out.println(soup);
                maintenanceRequests.add(new MaintenanceRequest(maintenanceData.getId(), maintenanceData.toObject(MaintenanceRequest.MaintenanceRequestData.class)));
            }
        }
        return maintenanceRequests;
    }
}
