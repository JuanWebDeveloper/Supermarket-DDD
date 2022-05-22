package com.ddd.supermarket.inventory.events;

import co.com.sofka.domain.generic.DomainEvent;

import com.ddd.supermarket.inventory.value.objects.DispenserID;
import com.ddd.supermarket.inventory.value.objects.Name;
import com.ddd.supermarket.inventory.value.objects.Phone;

public class EditedDispenser extends DomainEvent {
    private final DispenserID dispenserID;
    private final Name name;
    private final Phone phone;

    public EditedDispenser(DispenserID dispenserID, Name name, Phone phone) {
        super("supermarket.inventory.EditedDispenser");
        this.dispenserID = dispenserID;
        this.name = name;
        this.phone = phone;
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
