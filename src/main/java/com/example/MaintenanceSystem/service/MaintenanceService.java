package com.example.MaintenanceSystem.service;

import com.example.MaintenanceSystem.model.MaintenanceRequest;
import com.example.MaintenanceSystem.model.MaintenanceRequestData;
import com.example.MaintenanceSystem.model.TenantAccount;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
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
                maintenanceRequests.add(new MaintenanceRequest(maintenanceData.getId(), maintenanceData.toObject(MaintenanceRequestData.class)));
            }
        }
        return maintenanceRequests;
    }


    public MaintenanceRequest getMaintenanceRequestById(String requestId) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentSnapshot doc = db.collection(c)
                .document(requestId)
                .get().get();
        if(doc.exists()){
            return new MaintenanceRequest(doc.getId(), doc.toObject(MaintenanceRequestData.class));
        }
        return null;
    }

    public void completeRequest(String id) {
        Firestore db = FirestoreClient.getFirestore();
        Map<String, Object> map = new HashMap<>();
        map.put("status", "completed");
        db.collection(c).document(id).update(map);
    }
}
