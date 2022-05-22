package com.ddd.supermarket.inventory.value.objects;

import co.com.sofka.domain.generic.Identity;

public class InventoryID extends Identity {
    private InventoryID(String id) {
        super(id);
    }

    public InventoryID(){}
}
