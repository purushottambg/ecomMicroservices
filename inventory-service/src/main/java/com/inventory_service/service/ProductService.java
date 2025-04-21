package com.inventory_service.service;

import com.inventory_service.dto.ItemsDTO;
import com.inventory_service.dto.ProductDTO;
import com.inventory_service.entity.ProductEntity;
import com.inventory_service.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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

    public List<ProductDTO> addStocksToTheInventory(List<ProductDTO> products){

        List<ProductEntity> productEntities = products.stream()
                .map(productLambada -> modelMapper.map(productLambada,ProductEntity.class)).toList();

          productRepository.saveAll(productEntities);

          return products;
    }

    @Transactional
    public Double reduceStock(List<ItemsDTO> productDTO) {
        Double cartPrice=0d;
        for (ItemsDTO productOrder : productDTO) {

            logger.info("We received {} units request for product {}", productOrder.getQuantity(), productOrder.getProductId());
            Long productId = productOrder.getProductId();
            Integer quantity = productOrder.getQuantity();

            ProductEntity productAvailableStock = productRepository.findById(productId).orElseThrow(
                    () -> new RuntimeException("Couldn't find the product with id: " + productOrder.getProductId())
            );

            if (productAvailableStock == null) {
                throw new RuntimeException("Couldn't find the product with id: " + productOrder.getProductId());
            }

            if (productOrder.getQuantity() > productAvailableStock.getStock()) {
                throw new RuntimeException("Insufficient Stock for " + productAvailableStock.getName() + ", available stock is " + productAvailableStock.getStock());
            }

            productAvailableStock.setStock(productAvailableStock.getStock() - productOrder.getQuantity());

            cartPrice+=productAvailableStock.getPrice() * quantity;
            logger.info("Cart price after {} product is {}",productAvailableStock.getName(), cartPrice);

            productRepository.save(productAvailableStock);
        }

        return cartPrice;
    }
}
