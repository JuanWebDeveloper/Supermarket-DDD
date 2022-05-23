package com.ddd.supermarket.sales.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.business.repository.DomainEventRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.ddd.supermarket.sales.commands.CreateShoppingCart;
import com.ddd.supermarket.sales.events.SaleCreated;
import com.ddd.supermarket.sales.events.ShoppingCartCreated;
import com.ddd.supermarket.sales.value.objects.SalesID;
import com.ddd.supermarket.sales.value.objects.ShoppingCartID;
import org.mockito.Mockito;

import java.util.List;

public class CreateShoppingCartUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    void createShoppingCart() {
        ShoppingCartID shoppingCartID = ShoppingCartID.of("1018");
        SalesID salesID = SalesID.of("wano");

        CreateShoppingCart createShoppingCart = new CreateShoppingCart(salesID, shoppingCartID);
        CreateShoppingCartUseCase createShoppingCartUseCase = new CreateShoppingCartUseCase();

        Mockito.when(repository.getEventsBy("wano")).thenReturn(history());
        createShoppingCartUseCase.addRepository(repository);

        List<DomainEvent> events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(salesID.value())
                .syncExecutor(createShoppingCartUseCase, new RequestCommand<>(createShoppingCart))
                .orElseThrow(() -> new RuntimeException("Failed to create shopping cart"))
                .getDomainEvents();

        var handleEvent = (ShoppingCartCreated) events.get(0);
        Assertions.assertEquals("supermarket.sales.ShoppingCartCreated", handleEvent.type);
        Assertions.assertEquals("1018", handleEvent.getShoppingCartID().value());
    }

    private List<DomainEvent> history() {
        return List.of(new SaleCreated(SalesID.of("wano"), null));
    }
}
