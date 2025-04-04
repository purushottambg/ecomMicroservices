package com.inventory_service.service;

import com.inventory_service.dto.ProductDTO;
import com.inventory_service.entity.ProductEntity;
import com.inventory_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public  ProductDTO findByID(Long productID){
        ProductEntity toBeFoundEntity =
                productRepository.findById(productID)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return modelMapper.map(toBeFoundEntity, ProductDTO.class);
    }

}
