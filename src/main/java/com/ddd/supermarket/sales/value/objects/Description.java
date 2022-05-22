package com.ddd.supermarket.sales.value.objects;

import co.com.sofka.domain.generic.ValueObject;

public class Description implements ValueObject<String> {
    private final String description;

    private Description(String description) {
        this.description = description;
    }

    @Override
    public String value() {
        return this.description;
    }
}
