package com.kavach.kavach_backend.controller;

import com.kavach.kavach_backend.model.Evidence;
import com.kavach.kavach_backend.service.EvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/evidence")
@CrossOrigin(origins = "http://localhost:3001")
public class EvidenceController {

    @Autowired
    private EvidenceService evidenceService;

    @PostMapping("/save")
    public Evidence saveEvidence(@RequestBody Evidence evidence) {
        return evidenceService.saveEvidence(evidence);
    }

    @GetMapping("/{userPhone}")
    public List<Evidence> getEvidence(@PathVariable String userPhone) {
        return evidenceService.getEvidenceByUser(userPhone);
    }
}