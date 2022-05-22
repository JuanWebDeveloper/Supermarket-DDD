package com.ddd.supermarket.sales.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import com.ddd.supermarket.sales.Sales;
import com.ddd.supermarket.sales.commands.CreateShoppingCart;

public class CreateShoppingCartUseCase extends UseCase<RequestCommand<CreateShoppingCart>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateShoppingCart> createShoppingCartResponseEvents) {
        CreateShoppingCart command = createShoppingCartResponseEvents.getCommand();
        Sales sale = Sales.from(command.getSalesID(), retrieveEvents());
        sale.createShoppingCart(command.getShoppingCartID());

        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
