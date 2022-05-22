package com.ddd.supermarket.inventory.commands;

import co.com.sofka.domain.generic.Command;

import com.ddd.supermarket.inventory.value.objects.InventoryID;
import com.ddd.supermarket.inventory.value.objects.ProductID;
import com.ddd.supermarket.inventory.value.objects.Name;
import com.ddd.supermarket.inventory.value.objects.Description;
import com.ddd.supermarket.inventory.value.objects.Price;

public class EditProduct extends Command {
    private final InventoryID inventoryID;
    private final ProductID productID;
    private final Name name;
    private final Description description;
    private final Price price;

    public EditProduct(InventoryID inventoryID, ProductID productID, Name name, Description description, Price price) {
        this.inventoryID = inventoryID;
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public InventoryID getInventoryID() {
        return inventoryID;
    }

    public ProductID getProductID() {
        return productID;
    }

    public Name getName() {
        return name;
    }

    public Description getDescription() {
        return this.description;
    }

    public Price getPrice() {
        return this.price;
    }
}


