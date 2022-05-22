package com.ddd.supermarket.sales.entities;

import co.com.sofka.domain.generic.Entity;

import com.ddd.supermarket.sales.value.objects.*;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart extends Entity<ShoppingCartID> {
    private List<SaleProduct> productsOfCart = new ArrayList<>();

    public ShoppingCart(ShoppingCartID shoppingCartID) {
        super(shoppingCartID);
    }

    // Methods Of The Entity
    public void addProduct(ProductID productID, Name name, Description description, Price price) {
        SaleProduct saleProduct = new SaleProduct(productID, name, description, price);
        productsOfCart.add(saleProduct);
    }

    // Show The Entity Properties
    public List<SaleProduct> getProductsOfCart() {
        return productsOfCart;
    }
}
