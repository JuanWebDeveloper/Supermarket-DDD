package com.ddd.supermarket.inventory.entities;

import co.com.sofka.domain.generic.Entity;

// Value Objects
import com.ddd.supermarket.inventory.value.objects.ProductID;

public class Product extends Entity<ProductID> {
    private Product(ProductID productID) {
        super(productID);
    }
}
