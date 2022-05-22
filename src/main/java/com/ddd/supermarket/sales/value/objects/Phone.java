package com.ddd.supermarket.sales.value.objects;

import co.com.sofka.domain.generic.ValueObject;

public class Phone implements ValueObject<String> {
    private final String phone;

    private Phone(String phone) {
        this.phone = phone;
    }

    @Override
    public String value() {
        return this.phone;
    }
}
