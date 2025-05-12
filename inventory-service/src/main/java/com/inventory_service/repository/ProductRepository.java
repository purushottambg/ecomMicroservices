package com.inventory_service.repository;

import com.inventory_service.entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
