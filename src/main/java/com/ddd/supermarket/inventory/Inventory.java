package com.ddd.supermarket.inventory;

// Sofka Domains
import co.com.sofka.domain.generic.AggregateEvent;

// Value Objects
import com.ddd.supermarket.inventory.value.objects.*;

public class Inventory extends AggregateEvent<InventoryID> {
    private  Inventory(InventoryID inventoryID) {
        super(inventoryID);
    }
}
