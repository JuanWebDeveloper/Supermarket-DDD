package com.ddd.supermarket.inventory;

import co.com.sofka.domain.generic.EventChange;
import com.ddd.supermarket.inventory.events.*;

import java.util.ArrayList;

public class InventoryEventChange extends EventChange {
    public InventoryEventChange(Inventory inventory) {
        apply((InventoryCreated event) -> {
            inventory.dispensers = new ArrayList<>();
            inventory.products = new ArrayList<>();
        });
    }
}