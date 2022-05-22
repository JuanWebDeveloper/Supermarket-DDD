package com.ddd.supermarket.sales.events;

import co.com.sofka.domain.generic.DomainEvent;

import com.ddd.supermarket.sales.value.objects.SalesID;
import com.ddd.supermarket.sales.value.objects.Date;

public class SaleCreated extends DomainEvent {
    private final SalesID salesID;
    private final Date date;

    public SaleCreated(SalesID salesID, Date date) {
        super("supermarket.sales.SaleCreated");
        this.salesID = salesID;
        this.date = date;
    }

    public SalesID getSalesID() {
        return salesID;
    }

    public Date getDate() {
        return date;
    }
}
