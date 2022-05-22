package com.ddd.supermarket.inventory.events;

import co.com.sofka.domain.generic.DomainEvent;

import com.ddd.supermarket.inventory.value.objects.ProductID;
import com.ddd.supermarket.inventory.value.objects.Name;
import com.ddd.supermarket.inventory.value.objects.Description;
import com.ddd.supermarket.inventory.value.objects.Price;

public class AddedProduct extends DomainEvent {
    private final ProductID productID;
    private final Name name;
    private final Description description;
    private final Price price;

    public AddedProduct(ProductID productID, Name name, Description description, Price price) {
        super("supermarket.inventory.AddedProduct");
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ProductID getProductID() {
        return productID;
    }

    public Name getName() {
        return name;
    }

    public Description getDescription() {
        return description;
    }

    public Price getPrice() {
        return price;
    }
}
