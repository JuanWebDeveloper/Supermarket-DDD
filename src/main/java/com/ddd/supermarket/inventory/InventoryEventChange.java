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
            Dispenser dispenserToEdit = inventory.dispensers.stream()
                    .filter(item -> item.identity().equals(event.getDispenserID())).findFirst().get();
            dispenserToEdit.nameChange(event.getName());
            dispenserToEdit.phoneChange(event.getPhone());
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

        apply((EditedProduct event) -> {
            Product productToEdit = inventory.products.stream()
                    .filter(item -> item.identity().equals(event.getProductID())).findFirst().get();
            productToEdit.nameChange(event.getName());
            productToEdit.descriptionChange(event.getDescription());
            productToEdit.priceChange(event.getPrice());
        });

        apply((DeletedProduct event) -> {
            Product productToDelete = inventory.products.stream()
                    .filter(item -> item.identity().equals(event.getProductID())).findFirst()
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            inventory.products.remove(productToDelete);
        });
    }
}