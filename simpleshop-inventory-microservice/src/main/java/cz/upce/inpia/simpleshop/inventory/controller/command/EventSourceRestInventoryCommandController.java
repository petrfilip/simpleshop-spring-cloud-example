package cz.upce.inpia.simpleshop.inventory.controller.command;

import cz.upce.inpia.simpleshop.inventory.dto.InventoryDto;
import cz.upce.inpia.simpleshop.inventory.service.command.InventoryCommandService;
import cz.upce.inpia.simpleshop.inventory.service.query.InventoryQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/api/inventory/es/command")
@CrossOrigin
public class EventSourceRestInventoryCommandController {

    private final InventoryCommandService inventoryCommandService;
    private final InventoryQueryService inventoryQueryService;

    @Autowired
    public EventSourceRestInventoryCommandController(InventoryCommandService inventoryCommandService, InventoryQueryService inventoryQueryService) {
        this.inventoryCommandService = inventoryCommandService;
        this.inventoryQueryService = inventoryQueryService;
    }

    @PostMapping
    public CompletableFuture<Object> createNewItem(@RequestBody InventoryDto id) {
        return inventoryCommandService.createInventoryItem(id.getId());
    }

    @PutMapping
    public CompletableFuture<Object> addAmount(@RequestBody InventoryDto dto) {
        return inventoryCommandService.increaseAmount(dto);
    }

    @DeleteMapping
    public CompletableFuture<Object> removeAmount(@RequestBody InventoryDto dto) {
        return inventoryCommandService.decreaseAmount(dto);
    }

    @GetMapping("/events/{productId}")
    public List<Object> getAllEvents(@PathVariable("productId") Integer productId) {
        return inventoryQueryService.listEventsForAccount(productId);
    }

}
