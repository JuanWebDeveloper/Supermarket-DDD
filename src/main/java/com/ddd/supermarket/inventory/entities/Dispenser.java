package com.ddd.supermarket.inventory.entities;

import co.com.sofka.domain.generic.Entity;

// Value Objects
import com.ddd.supermarket.inventory.value.objects.DispenserID;
import com.ddd.supermarket.inventory.value.objects.Name;
import com.ddd.supermarket.inventory.value.objects.Phone;

import java.util.Objects;

public class Dispenser extends Entity<DispenserID> {
    private final DispenserID dispenserID;
    private Name name;
    private Phone phone;

    public Dispenser(DispenserID dispenserID, Name name, Phone phone) {
        super(dispenserID);
        this.dispenserID = dispenserID;
        this.name = name;
        this.phone = phone;
    }

    // Methods Of The Entity
    public DispenserID getDispenserID() {
        return dispenserID;
    }

    public void nameChange(Name newName) {
        this.name = Objects.requireNonNull(newName);
    }

    public void phoneChange(Phone newPhone) {
        this.phone = Objects.requireNonNull(newPhone);
    }

    // Show The Entity Properties
    public Name Name() {
        return name;
    }

    public Phone Phone() {
        return phone;
    }
}
