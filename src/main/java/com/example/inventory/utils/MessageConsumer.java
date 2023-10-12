package com.example.inventory.utils;

import com.example.inventory.entity.Inventory;
import com.example.inventory.model.Order;
import com.example.inventory.service.IInventoryService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @Autowired
    IInventoryService inventoryService;

    @Autowired
    MessageSender messageSender;

    @RabbitListener(queues = {"${queue.name.inventory}"})
    public void receive(@Payload String message) {
        try {
            System.out.println("Message " + message);
            Order orderDetails = UtilityMapper.responseToModel(message);
            Inventory inventory = inventoryService.getInventoryByProductId(orderDetails.getProductId());
            assert orderDetails != null;
            inventory.setQuantity(inventory.getQuantity() - orderDetails.getQuantity());
            inventoryService.createtUpdateInventory(inventory);
            messageSender.sendPaymentEvent(UtilityMapper.getJsonString(orderDetails));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}