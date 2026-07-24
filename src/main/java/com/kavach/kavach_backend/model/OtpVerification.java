package com.kavach.kavach_backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class OtpVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phone;
    private String otp;
    private LocalDateTime expiryTime;
    private boolean verified;

    public OtpVerification() {}

    public OtpVerification(String phone, String otp, LocalDateTime expiryTime) {
        this.phone = phone;
        this.otp = otp;
        this.expiryTime = expiryTime;
        this.verified = false;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getOtp() { return otp; }
    public void setOtp(String otp) { this.otp = otp; }

    public LocalDateTime getExpiryTime() { return expiryTime; }
    public void setExpiryTime(LocalDateTime expiryTime) { this.expiryTime = expiryTime; }

    public boolean isVerified() { return verified; }
    public void setVerified(boolean verified) { this.verified = verified; }
}