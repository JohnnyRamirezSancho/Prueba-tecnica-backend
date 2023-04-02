package com.pruebastecnicas.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebastecnicas.backend.models.ShoppingCartItem;

public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, Long>{
  
}