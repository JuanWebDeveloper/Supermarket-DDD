package com.ddd.supermarket.sales.entities;

import co.com.sofka.domain.generic.Entity;

// Value Objects
import com.ddd.supermarket.sales.value.objects.CustomerID;
import com.ddd.supermarket.sales.value.objects.Name;
import com.ddd.supermarket.sales.value.objects.Phone;

import java.util.Objects;

public class Customer extends Entity<CustomerID> {
    protected Name name;
    protected Phone phone;

    public Customer(CustomerID customerID, Name name, Phone phone) {
        super(customerID);
        this.name = name;
        this.phone = phone;
    }

    // Methods Of The Entity
    public void nameChange(Name newName) {
        this.name = Objects.requireNonNull(newName);
    }

    public void phoneChange(Phone newPhone) {
        this.phone = Objects.requireNonNull(newPhone);
    }

    // Show The Entity Properties
    public Name Name() {
        return name;
    }

    public Phone Phone() {
        return phone;
    }
}
