package com.ddd.supermarket.sales.events;

import co.com.sofka.domain.generic.DomainEvent;

import com.ddd.supermarket.sales.value.objects.ProductID;
import com.ddd.supermarket.sales.value.objects.Name;
import com.ddd.supermarket.sales.value.objects.Description;
import com.ddd.supermarket.sales.value.objects.Price;

public class ProductAddedToCart extends DomainEvent {
    private final ProductID productID;
    private final Name name;
    private final Description description;
    private final Price price;

    public ProductAddedToCart(ProductID productID, Name name, Description description, Price price) {
        super("supermarket.sales.ProductAddedToCart");
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
