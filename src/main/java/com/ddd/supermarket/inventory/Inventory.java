package com.ddd.supermarket.inventory;

// Sofka Domains
import co.com.sofka.domain.generic.AggregateEvent;

// Value Objects
import com.ddd.supermarket.inventory.entities.Dispenser;
import com.ddd.supermarket.inventory.entities.Product;
import com.ddd.supermarket.inventory.value.objects.*;

import java.util.List;

public class Inventory extends AggregateEvent<InventoryID> {
    protected List<Dispenser> dispensers;
    protected List<Product> products;

    private  Inventory(InventoryID inventoryID) {
        super(inventoryID);
    }
}
