package com.example.inventory.service;

import com.example.inventory.entity.Inventory;

public interface IInventoryService {
    Inventory getInventory(Long id);

    Inventory createtUpdateInventory(Inventory inventory);

    Inventory getInventoryByProductId(Long productId);
}
