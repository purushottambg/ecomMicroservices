package com.customer_service.dtos;

import com.customer_service.dtos.enums.RolesEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
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
