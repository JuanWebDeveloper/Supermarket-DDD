package com.ddd.supermarket.sales;

import co.com.sofka.domain.generic.EventChange;
import com.ddd.supermarket.sales.entities.ShoppingCart;
import com.ddd.supermarket.sales.events.*;

public class SalesEventChange extends EventChange {
    public  SalesEventChange(Sales sales) {
        apply((SaleCreated event) -> {
            sales.date = event.getDate();
        });

        apply((ShoppingCartCreated event) -> {
            sales.shoppingCart = new ShoppingCart(event.getShoppingCartID());
        });

        apply((ProductAddedToCart event) -> {
            sales.shoppingCart.addProduct(event.getProductID(), event.getName(), event.getDescription(), event.getPrice());
        });
    }
}
