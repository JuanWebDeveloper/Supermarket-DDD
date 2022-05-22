package com.ddd.supermarket.sales.value.objects;

import com.ddd.supermarket.sales.entities.ShoppingCart;
import com.ddd.supermarket.sales.entities.SaleProduct;

import co.com.sofka.domain.generic.ValueObject;

public class Total implements ValueObject<Double> {
    Double countTotal = 0.0;
    private final ShoppingCartID shoppingCartID;

    public Total(ShoppingCartID shoppingCartID) {
        this.shoppingCartID = shoppingCartID;
    }

    public Double addingTotalOfProducts() {
        ShoppingCart shoppingCart = new ShoppingCart(shoppingCartID);

        for (SaleProduct saleProduct : shoppingCart.getProductsOfCart()) {
            countTotal += saleProduct.price().value();
        }

        return countTotal;
    }

    @Override
    public Double value() {
        return addingTotalOfProducts();
    }
}
