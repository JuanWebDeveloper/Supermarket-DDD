package com.ddd.supermarket.sales.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.ddd.supermarket.sales.value.objects.ShoppingCartID;

public class ShoppingCartCreated extends DomainEvent {
    private final ShoppingCartID shoppingCartID;

    public ShoppingCartCreated(ShoppingCartID shoppingCartID) {
        super("supermarket.sales.ShoppingCartCreated");
        this.shoppingCartID = shoppingCartID;
    }

    public ShoppingCartID getShoppingCartID() {
        return shoppingCartID;
    }

}
