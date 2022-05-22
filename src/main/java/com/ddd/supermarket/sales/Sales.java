package com.ddd.supermarket.sales;

import co.com.sofka.domain.generic.AggregateEvent;

// Entities
import com.ddd.supermarket.sales.entities.Customer;
import com.ddd.supermarket.sales.entities.ShoppingCart;

// Value Objects
import com.ddd.supermarket.sales.value.objects.*;

// Events
import co.com.sofka.domain.generic.DomainEvent;
import com.ddd.supermarket.sales.events.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    // Behaviors Of The Aggregate
    public void createShoppingCart(ShoppingCartID shoppingCartID) {
        appendChange(new ShoppingCartCreated(Objects.requireNonNull(shoppingCartID))).apply();
    }

    public void addProductToCart(ProductID productID, Name name, Description description, Price price) {
        appendChange(new ProductAddedToCart(
                Objects.requireNonNull(productID),
                Objects.requireNonNull(name),
                Objects.requireNonNull(description),
                Objects.requireNonNull(price))
        ).apply();
    }

    public void createCustomer(CustomerID customerID, Name name, Phone phone) {
        for (Customer customer : customers) {
            if (customer.identity().equals(customerID)) {
                throw new IllegalArgumentException("Customer already exists");
            }
            Customer newCustomer = new Customer(customerID, name, phone);
            customers.add(newCustomer);
        }
    }

    public void editCustomer(CustomerID customerID, Name name, Phone phone) {
        for (Customer customer : customers) {
            if (customer.identity().equals(customerID)) {
                customer.nameChange(name);
                customer.phoneChange(phone);
            } else {
                throw new IllegalArgumentException("Customer not found");
            }
        }
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
