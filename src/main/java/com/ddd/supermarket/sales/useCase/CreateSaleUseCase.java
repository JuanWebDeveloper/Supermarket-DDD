package com.ddd.supermarket.sales.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import com.ddd.supermarket.sales.Sales;
import com.ddd.supermarket.sales.commands.CreateSale;

public class CreateSaleUseCase extends UseCase<RequestCommand<CreateSale>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateSale> createSaleResponseEvents) {
        CreateSale command = createSaleResponseEvents.getCommand();
        Sales sale = new Sales(command.getSalesID(), command.getDate());

        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
