package com.kavach.kavach_backend.repository;

import com.kavach.kavach_backend.model.SOSAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SOSAlertRepository extends JpaRepository<SOSAlert, Long> {
    List<SOSAlert> findByUserPhone(String userPhone);
}

