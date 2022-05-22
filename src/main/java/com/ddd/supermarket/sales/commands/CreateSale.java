package com.ddd.supermarket.sales.commands;

import co.com.sofka.domain.generic.Command;

import com.ddd.supermarket.sales.value.objects.SalesID;
import com.ddd.supermarket.sales.value.objects.Date;

public class CreateSale extends Command {
    private final SalesID salesID;
    private final Date date;

    public CreateSale(SalesID salesID, Date date) {
        this.salesID = salesID;
        this.date = date;
    }

    public SalesID getSalesID() {
        return this.salesID;
    }

    public Date getDate() {
        return this.date;
    }
}
