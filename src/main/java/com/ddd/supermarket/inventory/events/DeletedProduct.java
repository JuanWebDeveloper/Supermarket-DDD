package com.ddd.supermarket.inventory.events;

import co.com.sofka.domain.generic.DomainEvent;

import com.ddd.supermarket.inventory.value.objects.ProductID;

public class DeletedProduct extends DomainEvent {
    private final ProductID productID;

    public DeletedProduct(ProductID productID) {
        super("supermarket.inventory.DeletedProduct");
        this.productID = productID;
    }

    public ProductID getProductID() {
        return productID;
    }
}
