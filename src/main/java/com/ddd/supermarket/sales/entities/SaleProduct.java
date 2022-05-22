package com.ddd.supermarket.sales.entities;

import co.com.sofka.domain.generic.Entity;

// Value Objects
import com.ddd.supermarket.sales.value.objects.ProductID;
import com.ddd.supermarket.sales.value.objects.Name;
import com.ddd.supermarket.sales.value.objects.Description;
import com.ddd.supermarket.sales.value.objects.Price;

import java.util.Objects;

public class SaleProduct extends Entity<ProductID> {
    private Name name;
    private Description description;
    private Price price;

    public SaleProduct(ProductID productID, Name name, Description description, Price price) {
        super(productID);
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Methods Of The Entity
    public void nameChange(Name newName) {
        this.name = Objects.requireNonNull(newName);
    }

    public void descriptionChange(Description newDescription) {
        this.description = Objects.requireNonNull(newDescription);
    }

    public void priceChange(Price newPrice) {
        this.price = Objects.requireNonNull(newPrice);
    }

    // Show The Entity Properties
    public Name Name() {
        return name;
    }

    public Description Description() {
        return description;
    }

    public Price price() {
        return price;
    }
}
