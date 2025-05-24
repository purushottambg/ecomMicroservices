package com.customer_service.dtos;

import com.customer_service.dtos.enums.RolesEnum;

import java.time.LocalDate;

public class SignUpDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private RolesEnum roles;
    private String address;
    private String password; // hash it!
    private LocalDate registeredAt;
}
