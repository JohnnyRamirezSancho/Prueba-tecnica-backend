package com.pruebastecnicas.backend.services;

import org.springframework.stereotype.Service;

import com.pruebastecnicas.backend.models.ShoppingCartItem;
import com.pruebastecnicas.backend.repositories.ShoppingCartItemRepository;

import java.util.List;

@Service
public class ShoppingCartItemService {
    private ShoppingCartItemRepository repository;

    public ShoppingCartItemService(ShoppingCartItemRepository repository) {
        this.repository = repository;
    }

    public List<ShoppingCartItem> getAll() {
        return repository.findAll();
    }

    public ShoppingCartItem getOne(Long id) {
        ShoppingCartItem ShoppingCartItem = repository.findById(id).orElse(null);
        return ShoppingCartItem;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
