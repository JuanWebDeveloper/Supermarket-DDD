package com.ddd.supermarket.inventory;

import co.com.sofka.domain.generic.EventChange;
import com.ddd.supermarket.inventory.events.*;

// Entities
import com.ddd.supermarket.inventory.entities.Dispenser;
import com.ddd.supermarket.inventory.entities.Product;

import java.util.ArrayList;

public class InventoryEventChange extends EventChange {
    public InventoryEventChange(Inventory inventory) {
        apply((InventoryCreated event) -> {
            inventory.dispensers = new ArrayList<>();
            inventory.products = new ArrayList<>();
        });

        apply((AddedDispenser event) -> {
            Dispenser dispenser = new Dispenser(event.getDispenserID(), event.getName(), event.getPhone());
            inventory.dispensers.add(dispenser);
        });

        apply((EditedDispenser event) -> {
            Dispenser dispenser = inventory.dispensers.stream()
                    .filter(item -> item.identity().equals(event.getDispenserID())).findFirst().get();
            dispenser.nameChange(event.getName());
            dispenser.phoneChange(event.getPhone());
        });

        apply((DeletedDispenser event) -> {
            Dispenser dispenserToDelete = inventory.dispensers.stream()
                    .filter(item -> item.identity().equals(event.getDispenserID())).findFirst()
                    .orElseThrow(() -> new RuntimeException("Dispenser not found"));
            inventory.dispensers.remove(dispenserToDelete);
        });

        apply((AddedProduct event) -> {
            Product product = new Product(event.getProductID(), event.getName(), event.getDescription(), event.getPrice());
            inventory.products.add(product);
        });
    }
}