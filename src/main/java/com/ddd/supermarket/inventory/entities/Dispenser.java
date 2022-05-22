package com.ddd.supermarket.inventory.entities;

import co.com.sofka.domain.generic.Entity;

// Value Objects
import com.ddd.supermarket.inventory.value.objects.DispenserID;
import com.ddd.supermarket.inventory.value.objects.Name;
import com.ddd.supermarket.inventory.value.objects.Phone;

public class Dispenser extends Entity<DispenserID> {
    private Name name;
    private Phone phone;

    private Dispenser(DispenserID dispenserID, Name name, Phone phone) {
        super(dispenserID);
        this.name = name;
        this.phone = phone;
    }
}
