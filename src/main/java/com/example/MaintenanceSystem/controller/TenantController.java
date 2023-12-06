package com.example.MaintenanceSystem.controller;

import com.example.MaintenanceSystem.model.MaintenanceRequest;
import com.example.MaintenanceSystem.model.MaintenanceRequestData;
import com.example.MaintenanceSystem.model.TenantAccount;
import com.example.MaintenanceSystem.service.TenantService;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.ExecutionException;

@Controller
public class TenantController {
    public TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
        //TODO get id from security login to use for fetching tenant account
    }

    @GetMapping("/request")
    public String tenantRequestPage(Model model){
        return "make-request";
    }
    @PostMapping("/request/create")
    public String createRequestPage(Model model, @RequestParam String description, @RequestParam String problemArea) throws ExecutionException, InterruptedException {
        String errors = tenantService.validateFormSubmit(description, problemArea);
//        TenantAccount tenantAccount = tenantService.getTenant(SecurityContextHolder.getContext().getAuthentication().getName());
        TenantAccount tenantAccount = tenantService.getTenant("DURI6qZTaFNqZpyINBCY");

        if (errors==null){
            model.addAttribute("success", "Database changes saved");
            tenantService.createMaintenanceRequest(new MaintenanceRequestData(tenantAccount.getApartmentNumber(), description, problemArea, "pending"));
        }else{
            model.addAttribute("errors", errors);
            model.addAttribute("description", description);
            model.addAttribute("problemArea", problemArea);
        }
        return "redirect:/";
    }
}
