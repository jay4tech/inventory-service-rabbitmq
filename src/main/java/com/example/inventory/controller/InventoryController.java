package com.example.inventory.controller;

import com.example.inventory.entity.Inventory;
import com.example.inventory.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("inventory")
public class InventoryController {

    @Autowired
    IInventoryService inventoryService;

    @GetMapping("/{id}")
    public Inventory getInventory(@PathVariable Long id){
        return inventoryService.getInventory(id);
    }

    @PostMapping("/")
    public Inventory createtInventory(@RequestBody Inventory inventory){
        return inventoryService.createtInventory(inventory);
    }

}
