package com.ddd.supermarket.sales.commands;

import co.com.sofka.domain.generic.Command;
import com.ddd.supermarket.sales.value.objects.SalesID;
import com.ddd.supermarket.sales.value.objects.ShoppingCartID;

public class CreateShoppingCart extends Command {
    private final SalesID salesID;
    private final ShoppingCartID shoppingCartID;

    public CreateShoppingCart(SalesID salesID, ShoppingCartID shoppingCartID) {
        this.salesID = salesID;
        this.shoppingCartID = shoppingCartID;
    }

    public SalesID getSalesID() {
        return salesID;
    }

    public ShoppingCartID getShoppingCartID() {
        return shoppingCartID;
    }
}
