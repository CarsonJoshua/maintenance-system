package com.example.MaintenanceSystem.controller;

import com.example.MaintenanceSystem.service.MaintenanceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.ExecutionException;

@Controller
public class MaintenanceController {

    public MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @GetMapping("/maintenance")
    public String logPage(Model model) throws ExecutionException, InterruptedException {
        model.addAttribute("maintenanceRequestList", maintenanceService.getMaintenanceRequests());
        return "maintenance-list";
    }

    @GetMapping("/maintenance/request")
    public String usersPage(Model model, @RequestParam String requestId) throws ExecutionException, InterruptedException {
        String errors = maintenanceService.validateFormSubmit(requestId);
        if(errors==null){
            model.addAttribute("maintenanceRequest", maintenanceService.getMaintenanceRequestById(requestId));
            return "maintenance-request";
        }
        return "redirect:/";
    }
}
