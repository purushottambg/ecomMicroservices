package com.customer_service.service;

import com.customer_service.dtos.CustomerDTO;
import com.customer_service.dtos.SignUpDTO;
import com.customer_service.entity.CustomerEntity;
import com.customer_service.repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private CustomerDTO customerDTO;
    private CustomerRepo customerRepo;
    private CustomerEntity customerEntity;
    private ModelMapper modelMapper;

    public Optional<CustomerEntity> createUser(SignUpDTO customerDTO) {
        CustomerEntity customerEntityToBeSaved = modelMapper.map(customerDTO, CustomerEntity.class);
        return Optional.ofNullable(customerRepo.save(customerEntityToBeSaved));
    }


//    public Optional<CustomerEntity> validateLoginRequest(CustomerDTO customerDTO) {
//        Optional<CustomerEntity> savedEntity = customerRepo.findByID(customerDTO.getId());
//        return savedEntity;
//    }
}
