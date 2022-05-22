package com.ddd.supermarket.sales;

import co.com.sofka.domain.generic.AggregateEvent;

// Entities
import com.ddd.supermarket.sales.entities.Customer;
import com.ddd.supermarket.sales.entities.ShoppingCart;

// Value Objects
import com.ddd.supermarket.sales.value.objects.SalesID;
import com.ddd.supermarket.sales.value.objects.PaymentMethod;
import com.ddd.supermarket.sales.value.objects.Total;
import com.ddd.supermarket.sales.value.objects.Date;
import com.ddd.supermarket.sales.value.objects.Invoice;

// Events
import co.com.sofka.domain.generic.DomainEvent;
import com.ddd.supermarket.sales.events.*;

import java.util.ArrayList;
import java.util.List;

public class Sales extends AggregateEvent<SalesID> {
    protected Customer customer;
    protected ShoppingCart shoppingCart;
    protected PaymentMethod paymentMethod;
    protected Total total;
    protected Date date;
    protected Invoice invoice;
    private List<Customer> customers = new ArrayList<>();

    private Sales(SalesID salesID, Date date) {
        super(salesID);
        subscribe(new SalesEventChange(this));
        appendChange(new SaleCreated(salesID, date)).apply();
    }

    public Sales(SalesID salesID) {
        super(salesID);
        subscribe(new SalesEventChange(this));
    }

    // Get Event Logs
    public static Sales from(SalesID salesID, List<DomainEvent> events) {
        Sales sales = new Sales(salesID);
        events.forEach(sales::applyEvent);
        return sales;
    }

    // Show The Entity Properties
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public Total getTotal() {
        return total;
    }

    public Date getDate() {
        return date;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
