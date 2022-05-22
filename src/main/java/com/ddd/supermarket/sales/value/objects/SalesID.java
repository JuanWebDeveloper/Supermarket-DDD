package com.ddd.supermarket.sales.value.objects;

import co.com.sofka.domain.generic.Identity;

public class SalesID extends Identity {
    private SalesID(String id) {
        super(id);
    }

    public SalesID() {}

    public static SalesID of(String id) {
        return new SalesID(id);
    }
}
