package com.kavach.kavach_backend.service;

import com.kavach.kavach_backend.model.Evidence;
import com.kavach.kavach_backend.repository.EvidenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EvidenceService {

    @Autowired
    private EvidenceRepository evidenceRepository;

    public Evidence saveEvidence(Evidence evidence) {
        evidence.setCreatedAt(LocalDateTime.now());
        return evidenceRepository.save(evidence);
    }

    public List<Evidence> getEvidenceByUser(String userPhone) {
        return evidenceRepository.findByUserPhone(userPhone);
    }
}