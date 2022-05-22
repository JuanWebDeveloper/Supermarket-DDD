package com.ddd.supermarket.sales.entities;

import co.com.sofka.domain.generic.Entity;

import com.ddd.supermarket.sales.value.objects.ShoppingCartID;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart extends Entity<ShoppingCartID> {
    private List<SaleProduct> productsOfCart = new ArrayList<>();

    public ShoppingCart(ShoppingCartID shoppingCartID) {
        super(shoppingCartID);
    }

    // Show The Entity Properties
    public List<SaleProduct> getProductsOfCart() {
        return productsOfCart;
    }
}
