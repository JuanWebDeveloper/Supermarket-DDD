package com.ddd.supermarket.inventory.commands;

import co.com.sofka.domain.generic.Command;

import com.ddd.supermarket.inventory.value.objects.InventoryID;
import com.ddd.supermarket.inventory.value.objects.ProductID;

public class DeleteProduct extends Command {
    private final InventoryID inventoryID;
    private final ProductID productID;

    public DeleteProduct(InventoryID inventoryID, ProductID productID) {
        this.inventoryID = inventoryID;
        this.productID = productID;
    }

    public InventoryID getInventoryID() {
        return inventoryID;
    }

    public ProductID getProductID() {
        return productID;
    }
}
