package com.kavach.kavach_backend.repository;

import com.kavach.kavach_backend.model.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EvidenceRepository extends JpaRepository<Evidence, Long> {
    List<Evidence> findByUserPhone(String userPhone);
}