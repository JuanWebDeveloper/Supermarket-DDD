package com.ddd.supermarket.sales;

import co.com.sofka.domain.generic.AggregateEvent;

// Value Objects
import com.ddd.supermarket.sales.value.objects.SalesID;

public class Sales extends AggregateEvent<SalesID> {
    private Sales(SalesID salesID) {
        super(salesID);
    }
}
