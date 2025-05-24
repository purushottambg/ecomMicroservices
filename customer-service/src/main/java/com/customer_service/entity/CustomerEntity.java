package com.customer_service.entity;

import com.customer_service.dtos.enums.RolesEnum;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fname;
    private String sname;
    private String lname;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    private RolesEnum roles;
    private String address;
    private String password; // hash it!
    private LocalDate registeredAt;
}
