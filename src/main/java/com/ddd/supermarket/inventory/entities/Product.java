package com.ddd.supermarket.inventory.entities;

import co.com.sofka.domain.generic.Entity;

// Value Objects
import com.ddd.supermarket.inventory.value.objects.ProductID;
import com.ddd.supermarket.inventory.value.objects.Name;
import com.ddd.supermarket.inventory.value.objects.Description;
import com.ddd.supermarket.inventory.value.objects.Price;

public class Product extends Entity<ProductID> {
    private Name name;
    private Description description;
    private Price price;

    public Product(ProductID productId, Name name, Description description, Price price) {
        super(productId);
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
