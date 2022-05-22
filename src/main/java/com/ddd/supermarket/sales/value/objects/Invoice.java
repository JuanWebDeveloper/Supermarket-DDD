package com.ddd.supermarket.sales.value.objects;

import co.com.sofka.domain.generic.ValueObject;

public class Invoice implements ValueObject<String> {
    private final Date date;
    private final PaymentMethod paymentMethod;
    private final Total total;

    public Invoice(Date date, PaymentMethod paymentMethod, Total total) {
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.total = total;
    }

    public String printInvoice() {
        return "Invoice {" +
                "date=" + date +
                ", paymentMethod=" + paymentMethod +
                ", total=" + total +
                '}';
    }

    @Override
    public String value() {
        return this.printInvoice();
    }
}
