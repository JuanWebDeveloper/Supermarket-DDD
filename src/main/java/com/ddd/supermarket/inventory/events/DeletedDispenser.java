package com.ddd.supermarket.inventory.events;

import co.com.sofka.domain.generic.DomainEvent;

import com.ddd.supermarket.inventory.value.objects.DispenserID;

public class DeletedDispenser extends DomainEvent {
    private final DispenserID dispenserID;

    public DeletedDispenser(DispenserID dispenserID) {
        super("supermarket.inventory.DeletedDispenser");
        this.dispenserID = dispenserID;
    }

    public DispenserID getDispenserID() {
        return dispenserID;
    }
}
