package com.ddd.supermarket.sales.value.objects;

import co.com.sofka.domain.generic.Identity;

public class ProductID extends Identity {
    private ProductID(String id) {
        super(id);
    }

    public ProductID() {}

    public static ProductID of(String id) {
        return new ProductID(id);
    }
}
