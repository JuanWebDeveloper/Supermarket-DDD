package com.ddd.supermarket.inventory;

// Sofka Domains
import co.com.sofka.domain.generic.AggregateEvent;

// Value Objects
import com.ddd.supermarket.inventory.entities.Dispenser;
import com.ddd.supermarket.inventory.entities.Product;
import com.ddd.supermarket.inventory.value.objects.*;

// Events
import co.com.sofka.domain.generic.DomainEvent;
import com.ddd.supermarket.inventory.events.*;

import java.util.List;
import java.util.Objects;

public class Inventory extends AggregateEvent<InventoryID> {
    protected List<Dispenser> dispensers;
    protected List<Product> products;

    private Inventory(InventoryID inventoryID) {
        super(inventoryID);
        subscribe(new InventoryEventChange(this));
        appendChange(new InventoryCreated(inventoryID));
    }

    // Get Event Logs
    public static Inventory from(InventoryID inventoryID, List<DomainEvent> events) {
        Inventory inventory = new Inventory(inventoryID);
        events.forEach(inventory::applyEvent);
        return inventory;
    }

    // Behaviors Of The Aggregate
    public void addDispenser(DispenserID dispenserId, Name name, Phone phone) {
        appendChange(new AddedDispenser(
                Objects.requireNonNull(dispenserId),
                Objects.requireNonNull(name),
                Objects.requireNonNull(phone))
        ).apply();
    }

    public void editDispenser(DispenserID dispenserId, Name name, Phone phone) {
        appendChange(new EditedDispenser(
                Objects.requireNonNull(dispenserId),
                Objects.requireNonNull(name),
                Objects.requireNonNull(phone))
        ).apply();
    }

    public void deleteDispenser(DispenserID dispenserId) {
        appendChange(new DeletedDispenser(Objects.requireNonNull(dispenserId))).apply();
    }

    public void addProduct(ProductID productId, Name name, Description description, Price price) {
        appendChange(new AddedProduct(
                Objects.requireNonNull(productId),
                Objects.requireNonNull(name),
                Objects.requireNonNull(description),
                Objects.requireNonNull(price))
        ).apply();
    }

    // Show The Properties Of The Entities Of The Aggregate
    public List<Dispenser> Dispensers() {
        return dispensers;
    }

    public List<Product> Products() {
        return products;
    }
}
