package com.ddd.supermarket.inventory.commands;

import co.com.sofka.domain.generic.Command;

import com.ddd.supermarket.inventory.value.objects.ProductID;
import com.ddd.supermarket.inventory.value.objects.Name;
import com.ddd.supermarket.inventory.value.objects.Description;
import com.ddd.supermarket.inventory.value.objects.Price;

public class AddProduct extends Command {
    // Add Sales ID When Creating The Respective Aggregate
    private final ProductID productID;
    private final Name name;
    private final Description description;
    private final Price price;

    public AddProduct(ProductID productID, Name name, Description description, Price price) {
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
