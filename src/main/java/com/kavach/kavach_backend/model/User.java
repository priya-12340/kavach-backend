package com.kavach.kavach_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private Integer age;
    private String gender;
    private String email;
    private String location;
    private String bloodGroup;

    private String contact1;
    private String contact2;
    private String contact3;
    private String contact4;
    private String contact5;
}

