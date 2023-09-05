package com.example.inventory.service;

import com.example.inventory.entity.Inventory;
import com.example.inventory.model.Order;

public interface IInventoryService {
    Inventory getInventory(Long id);

    Inventory createtInventory(Inventory inventory);

    Inventory getInventoryByProductId(Order orderDetails);
}
