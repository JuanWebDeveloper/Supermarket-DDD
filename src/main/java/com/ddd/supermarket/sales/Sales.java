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

    private Sales(SalesID salesID) {
        super(salesID);
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
