package com.example.inventory.service;

import com.example.inventory.entity.Inventory;
import com.example.inventory.model.Order;
import com.example.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService implements IInventoryService{

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public Inventory getInventory(Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    @Override
    public Inventory createtUpdateInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory getInventoryByProductId(Long productId) {
        return inventoryRepository.getInventoryByProductId(productId);
    }
}
