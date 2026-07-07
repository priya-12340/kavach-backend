package com.kavach.kavach_backend.controller;

import com.kavach.kavach_backend.model.SOSAlert;
import com.kavach.kavach_backend.service.SOSAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sos")
@CrossOrigin(origins = "http://localhost:3001")
public class SOSAlertController {

    @Autowired
    private SOSAlertService sosAlertService;

    @PostMapping("/trigger")
    public SOSAlert triggerSOS(@RequestBody SOSAlert alert) {
        return sosAlertService.triggerSOS(alert);
    }

    @GetMapping("/{phone}")
    public List<SOSAlert> getAlerts(@PathVariable String phone) {
        return sosAlertService.getAlertsByPhone(phone);
    }

    @GetMapping("/all")
    public List<SOSAlert> getAllAlerts() {
        return sosAlertService.getAllAlerts();
    }
}

