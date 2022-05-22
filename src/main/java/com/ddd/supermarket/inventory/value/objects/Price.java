package com.ddd.supermarket.inventory.value.objects;

import co.com.sofka.domain.generic.ValueObject;

public class Price implements ValueObject<Double> {
    private final Double price;

    private Price(Double price) {
        this.price = price;
    }

    @Override
    public Double value() {
        return this.price;
    }

    public Double getPrice() {
        return price;
    }
}