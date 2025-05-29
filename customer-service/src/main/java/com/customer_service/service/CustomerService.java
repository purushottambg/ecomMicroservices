package com.customer_service.service;


import com.customer_service.clients.InventoryClient;
import com.customer_service.dtos.ProductDTO;
import com.customer_service.dtos.SignUpDTO;
import com.customer_service.entity.CustomerEntity;
import com.customer_service.repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepo customerRepo;
    private final InventoryClient inventoryClient;
    private final ModelMapper modelMapper;

    public Optional<CustomerEntity> createUser(SignUpDTO signUpDTO) {
        CustomerEntity customerEntityToBeSaved = modelMapper.map(signUpDTO, CustomerEntity.class);
        return Optional.ofNullable(customerRepo.save(customerEntityToBeSaved));
    }

    public Optional<SignUpDTO> findUser(Long id) {
        SignUpDTO foundCustomer = modelMapper.map(customerRepo.findById(id), SignUpDTO.class);
        return Optional.ofNullable(foundCustomer);
    }

    public String greetingsFromInventory(){
        return inventoryClient.getGreetingsFromInventory();
    }

    public List<ProductDTO> findAllProductsInInventory(){
        return inventoryClient.findAllProductsInInventory();
    }

    public Integer findAllProductsCountInInventory(Long id){
        return inventoryClient.findAllProductsCountInInventory(id);
    }
}
