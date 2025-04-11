package com.inventory_service.service;

import com.inventory_service.dto.ProductDTO;
import com.inventory_service.entity.ProductEntity;
import com.inventory_service.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    Logger logger = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    ProductService( ProductRepository productRepository, ModelMapper modelMapper){
        this.productRepository=productRepository;
        this.modelMapper=modelMapper;
    }

    public ProductDTO findByID(Long productID){
        Optional <ProductEntity> toBeFoundEntity =
                productRepository.findById(productID);
        logger.info("To be returned Entity value is: {}",toBeFoundEntity);

        return toBeFoundEntity.map(item -> modelMapper.map(item, ProductDTO.class))
                .orElseThrow(() -> new RuntimeException("Inventory not found"));
    }

    public List<ProductDTO> findAll() {
        List<ProductEntity> productEntities =
                productRepository.findAll();
        if(productEntities.isEmpty()){
            logger.warn("List is empty");
        }else{
            logger.info("Total elements found in repository are: {}",productEntities.size());
            Iterator <ProductEntity> listIterator = productEntities.iterator();
            while (listIterator.hasNext()){
                ProductEntity element = listIterator.next();
                logger.info("Element is: {}",element);
            }
        }
        return productEntities.stream()
                .map(productEntity -> modelMapper.map(productEntity, ProductDTO.class))
                .toList();
    }

    @Transactional
    public Integer updateStockValue(Long productId, Integer quantity) {
         ProductEntity product = productRepository.findById(productId).orElseThrow(
                 ()-> new RuntimeException("Couldn't find the product")
         );
         if (product==null){
             throw new RuntimeException("Couldn't find the product");
         }

         product.setStock(product.getStock()-quantity);

         productRepository.save(product);

         return product.getStock();

    }
}
