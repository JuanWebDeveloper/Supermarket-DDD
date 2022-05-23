package com.ddd.supermarket.sales.commands;

import co.com.sofka.domain.generic.Command;

import com.ddd.supermarket.sales.value.objects.*;

public class AddProductToCart extends Command {
    private final SalesID salesID;
    private final ProductID productID;
    private final Name name;
    private final Description description;
    private final Price price;

    public AddProductToCart(SalesID salesID,ProductID productID, Name name, Description description, Price price) {
        this.salesID = salesID;
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public SalesID getSalesID() {
        return salesID;
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
