package com.ddd.supermarket.inventory.commands;

import co.com.sofka.domain.generic.Command;

import com.ddd.supermarket.inventory.value.objects.InventoryID;

public class CreateInventory extends Command {
    private final InventoryID inventoryID;

    public CreateInventory(InventoryID inventoryID) {
        this.inventoryID = inventoryID;
    }

    public InventoryID getInventoryID() {
        return inventoryID;
    }
}
