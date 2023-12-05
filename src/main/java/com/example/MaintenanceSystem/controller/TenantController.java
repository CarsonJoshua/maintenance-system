package com.example.MaintenanceSystem.controller;

import com.example.MaintenanceSystem.model.MaintenanceRequest;
import com.example.MaintenanceSystem.model.TenantAccount;
import com.example.MaintenanceSystem.service.TenantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TenantController {
    public TenantService tenantService;
    public TenantAccount tenantAccount;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping("/request")
    public String tenantRequestPage(Model model){
        return "make-request";
    }
    @PostMapping("/request/create")
    public String createRequestPage(Model model, @RequestParam String description, String problemArea){
        String errors = tenantService.validateFormSubmit(description, problemArea);
        if (errors==null){
            model.addAttribute("success", "Database changes saved");
            tenantService.createMaintenanceRequest(new MaintenanceRequest.MaintenanceRequestData(tenantAccount.getApartmentNumber(), description, problemArea, "pending"));
        }else{
            model.addAttribute("errors", errors);
            model.addAttribute("description", description);
            model.addAttribute("problemArea", problemArea);
        }
        return "redirect:/";
    }
}
