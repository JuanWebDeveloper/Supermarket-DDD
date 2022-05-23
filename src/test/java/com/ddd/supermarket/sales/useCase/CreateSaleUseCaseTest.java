package com.ddd.supermarket.sales.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.ddd.supermarket.sales.commands.CreateSale;
import com.ddd.supermarket.sales.events.SaleCreated;
import com.ddd.supermarket.sales.value.objects.Date;
import com.ddd.supermarket.sales.value.objects.SalesID;

import java.util.List;

public class CreateSaleUseCaseTest {
    @Test
    void createSale() {
        SalesID salesID = new SalesID();
        Date date = new Date();

        CreateSale createSale = new CreateSale(salesID, date);
        CreateSaleUseCase createSaleUseCase = new CreateSaleUseCase();

        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(createSaleUseCase, new RequestCommand<>(createSale))
                .orElseThrow(() -> new RuntimeException("Could not create sale"))
                .getDomainEvents();

        var handleEvent = (SaleCreated) events.get(0);
        Assertions.assertEquals("supermarket.sales.SaleCreated", handleEvent.type);
        Assertions.assertEquals(salesID.value(), handleEvent.aggregateRootId());
    }
}
