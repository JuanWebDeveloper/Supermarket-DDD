package com.ddd.supermarket.inventory.entities;

import co.com.sofka.domain.generic.Entity;

// Value Objects
import com.ddd.supermarket.inventory.value.objects.DispenserID;

public class Dispenser extends Entity<DispenserID> {
    private Dispenser(DispenserID dispenserID) {
        super(dispenserID);
    }
}
