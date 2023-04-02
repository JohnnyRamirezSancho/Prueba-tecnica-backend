package com.pruebastecnicas.backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebastecnicas.backend.models.ShoppingCartItem;
import com.pruebastecnicas.backend.services.ShoppingCartItemService;

@RestController
@RequestMapping(path = "/api/shoppingcart")
public class ShoppingCartItemController {
    private ShoppingCartItemService service;

    public ShoppingCartItemController(ShoppingCartItemService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<ShoppingCartItem> listAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ShoppingCartItem listOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}