package com.kavach.kavach_backend.service;

import com.kavach.kavach_backend.model.SOSAlert;
import com.kavach.kavach_backend.repository.SOSAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SOSAlertService {

    @Autowired
    private SOSAlertRepository sosAlertRepository;

    public SOSAlert triggerSOS(SOSAlert alert) {
        return sosAlertRepository.save(alert);
    }

    public List<SOSAlert> getAlertsByPhone(String phone) {
        return sosAlertRepository.findByUserPhone(phone);
    }

    public List<SOSAlert> getAllAlerts() {
        return sosAlertRepository.findAll();
    }
}

