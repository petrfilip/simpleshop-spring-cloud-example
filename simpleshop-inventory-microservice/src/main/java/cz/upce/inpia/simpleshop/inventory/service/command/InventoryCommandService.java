package cz.upce.inpia.simpleshop.inventory.service.command;

import cz.upce.inpia.simpleshop.inventory.dto.InventoryDto;

import java.util.concurrent.CompletableFuture;

public interface InventoryCommandService {

    CompletableFuture<Object> createInventoryItem(Integer productId);

    CompletableFuture<Object> increaseAmount(InventoryDto dto);

    CompletableFuture<Object> decreaseAmount(InventoryDto dto);
}
