package com.ddd.supermarket.inventory.events;

import co.com.sofka.domain.generic.DomainEvent;

import com.ddd.supermarket.inventory.value.objects.InventoryID;

public class InventoryCreated extends DomainEvent {
    private final InventoryID inventoryID;

    public InventoryCreated(InventoryID inventoryID) {
        super("supermarket.inventory.InventoryCreated");
        this.inventoryID = inventoryID;
    }

    public InventoryID getInventoryID() {
        return inventoryID;
    }
}