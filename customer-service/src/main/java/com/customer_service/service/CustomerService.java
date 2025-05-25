package com.customer_service.service;


import com.customer_service.dtos.SignUpDTO;
import com.customer_service.entity.CustomerEntity;
import com.customer_service.repository.CustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
@Slf4j
public class CustomerService {
    private CustomerRepo customerRepo;
    private ModelMapper modelMapper;
    public CustomerService(CustomerRepo customerRepo, ModelMapper modelMapper) {
        this.customerRepo = customerRepo;
        this.modelMapper = modelMapper;
    }

    public Optional<CustomerEntity> createUser(SignUpDTO signUpDTO) {
        CustomerEntity customerEntityToBeSaved = modelMapper.map(signUpDTO, CustomerEntity.class);
        return Optional.ofNullable(customerRepo.save(customerEntityToBeSaved));
    }

}
