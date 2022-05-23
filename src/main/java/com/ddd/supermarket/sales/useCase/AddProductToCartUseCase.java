package com.ddd.supermarket.sales.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import com.ddd.supermarket.sales.Sales;
import com.ddd.supermarket.sales.commands.AddProductToCart;

public class AddProductToCartUseCase extends UseCase<RequestCommand<AddProductToCart>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddProductToCart> addProductToCartResponseEvents) {
        AddProductToCart command = addProductToCartResponseEvents.getCommand();
        Sales sale = Sales.from(command.getSalesID(), retrieveEvents());
        sale.addProductToCart(command.getProductID(), command.getName(), command.getDescription(), command.getPrice());

        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
