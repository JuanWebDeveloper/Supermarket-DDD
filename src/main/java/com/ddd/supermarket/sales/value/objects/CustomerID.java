package com.ddd.supermarket.sales.value.objects;

import co.com.sofka.domain.generic.Identity;

public class CustomerID extends Identity {
    private CustomerID(String id) {
        super(id);
    }

    public CustomerID() {}

    public static CustomerID of(String id) {
        return new CustomerID(id);
    }
}
