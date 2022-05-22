package com.ddd.supermarket.inventory.commands;

import co.com.sofka.domain.generic.Command;

import com.ddd.supermarket.inventory.value.objects.InventoryID;
import com.ddd.supermarket.inventory.value.objects.DispenserID;
import com.ddd.supermarket.inventory.value.objects.Name;
import com.ddd.supermarket.inventory.value.objects.Phone;

public class AddDispenser extends Command {
    private final InventoryID inventoryID;
    private final DispenserID dispenserID;
    private final Name name;
    private final Phone phone;

    public AddDispenser(InventoryID inventoryID, DispenserID dispenserID, Name name, Phone phone) {
        this.inventoryID = inventoryID;
        this.dispenserID = dispenserID;
        this.name = name;
        this.phone = phone;
    }

    public InventoryID getInventoryID() {
        return inventoryID;
    }

    public DispenserID getDispenserID() {
        return dispenserID;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }
}
