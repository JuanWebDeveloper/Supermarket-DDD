package com.ddd.supermarket.sales.value.objects;

import co.com.sofka.domain.generic.ValueObject;

public class Name implements ValueObject<String> {
    private final String name;

    private Name(String name) {
        this.name = name;
    }

    @Override
    public String value() {
        return this.name;
    }
}
