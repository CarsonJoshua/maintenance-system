package com.example.MaintenanceSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TenantController {
    @GetMapping("/request")
    public String tenantRequestPage(Model model){
        return "make-request";
    }
}
