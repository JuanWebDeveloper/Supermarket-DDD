package com.ddd.supermarket.inventory.value.objects;

import co.com.sofka.domain.generic.Identity;

public class ProductID extends Identity {
    private ProductID(String id){
        super(id);
    }

    public ProductID(){}
}
