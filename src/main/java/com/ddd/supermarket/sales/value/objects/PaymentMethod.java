package com.ddd.supermarket.sales.value.objects;

import co.com.sofka.domain.generic.ValueObject;

public class PaymentMethod implements ValueObject<PaymentMethod.Payment> {
    public enum Payment {CASH, CARD, CREDIT_CARD}
    private final Payment payment;

    public PaymentMethod(Payment payment) {
        this.payment = payment;
    }

    @Override
    public Payment value() {
        return payment;
    }
}
