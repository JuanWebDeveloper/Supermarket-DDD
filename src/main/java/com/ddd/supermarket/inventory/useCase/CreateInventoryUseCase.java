package com.ddd.supermarket.inventory.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import com.ddd.supermarket.inventory.Inventory;
import com.ddd.supermarket.inventory.commands.CreateInventory;

public class CreateInventoryUseCase extends UseCase<RequestCommand<CreateInventory>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateInventory> createInventoryRequestCommand) {
        CreateInventory command = createInventoryRequestCommand.getCommand();
        Inventory inventory = new Inventory(command.getInventoryID());
        emit().onResponse(new ResponseEvents(inventory.getUncommittedChanges()));
    }
}
