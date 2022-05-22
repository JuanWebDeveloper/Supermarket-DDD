package com.ddd.supermarket.inventory.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.ddd.supermarket.inventory.commands.CreateInventory;
import com.ddd.supermarket.inventory.events.InventoryCreated;
import com.ddd.supermarket.inventory.value.objects.InventoryID;

import java.util.List;

public class CreateInventoryUseCaseTest {
    @Test
    void createInventory() {
        InventoryID inventoryID = new InventoryID();
        CreateInventory createInventory = new CreateInventory(inventoryID);
        CreateInventoryUseCase createInventoryUseCase = new CreateInventoryUseCase();

        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(createInventoryUseCase, new RequestCommand<>(createInventory))
                .orElseThrow()
                .getDomainEvents();

        var handleEvent = (InventoryCreated) events.get(0);
        Assertions.assertEquals("supermarket.inventory.InventoryCreated", handleEvent.type);
        Assertions.assertEquals(inventoryID.value(), handleEvent.aggregateRootId());
    }
}
