package com.ddd.supermarket.sales.value.objects;

import co.com.sofka.domain.generic.Identity;

public class ShoppingCartID extends Identity {
    private ShoppingCartID(String id) {
        super(id);
    }

    public ShoppingCartID() {}

    public static ShoppingCartID of(String id) {
        return new ShoppingCartID(id);
    }
}
