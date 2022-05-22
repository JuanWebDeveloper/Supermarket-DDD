package com.ddd.supermarket.inventory.commands;

import co.com.sofka.domain.generic.Command;

import com.ddd.supermarket.inventory.value.objects.InventoryID;
import com.ddd.supermarket.inventory.value.objects.DispenserID;

public class DeleteDispenser extends Command {
    private InventoryID inventoryID;
    private DispenserID dispenserID;

    public DeleteDispenser(InventoryID inventoryID, DispenserID dispenserID) {
        this.inventoryID = inventoryID;
        this.dispenserID = dispenserID;
    }

    public InventoryID getInventoryID() {
        return inventoryID;
    }

    public DispenserID getDispenserID() {
        return dispenserID;
    }
}