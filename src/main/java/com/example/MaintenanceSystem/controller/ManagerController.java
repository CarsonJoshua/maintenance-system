package com.example.MaintenanceSystem.controller;

import com.example.MaintenanceSystem.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.ExecutionException;

@Controller
public class ManagerController {
    public ManagerService managerService;

    @GetMapping("/manager")
    public String managerPage(Model model){
        return "manager";
    }

    @GetMapping("/manager/tenants")
    public String tenantListPage(Model model) throws ExecutionException, InterruptedException {
        model.addAttribute("tenantList", managerService.getTenants());
        return "tenant-list";
    }
    @GetMapping("/manager/tenants/account")
    public String tenantAccountPage(Model model, @RequestParam String tenantId) throws ExecutionException, InterruptedException {
        String errors = managerService.validateFormSubmit(tenantId);
        if(errors==null){
            model.addAttribute("tenant", managerService.getTenantById(tenantId));
            return "tenant-account";
        }
        return "redirect:/";
    }
}
