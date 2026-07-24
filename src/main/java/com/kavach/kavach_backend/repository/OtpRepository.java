package com.kavach.kavach_backend.repository;

import com.kavach.kavach_backend.model.OtpVerification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<OtpVerification, Long> {
    Optional<OtpVerification> findTopByPhoneOrderByIdDesc(String phone);
}