package cz.upce.inpia.simpleshop.inventory.controller.query;

import cz.upce.inpia.simpleshop.inventory.service.query.InventoryCurrentAmountQueryService;
import cz.upce.inpia.simpleshop.inventory.service.query.InventoryQueryService;
import cz.upce.inpia.simpleshop.inventory.service.query.InventoryStatsQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/inventory/es/query")
@CrossOrigin
public class EventSourceRestInventoryQueryController {

    private final InventoryQueryService inventoryQueryService;
    private final InventoryStatsQueryService inventoryStatsQueryService;
    private final InventoryCurrentAmountQueryService inventoryCurrentAmountQueryService;

    @Autowired
    public EventSourceRestInventoryQueryController(InventoryQueryService inventoryQueryService, InventoryStatsQueryService inventoryStatsQueryService, InventoryCurrentAmountQueryService inventoryCurrentAmountQueryService) {
        this.inventoryQueryService = inventoryQueryService;
        this.inventoryStatsQueryService = inventoryStatsQueryService;
        this.inventoryCurrentAmountQueryService = inventoryCurrentAmountQueryService;
    }

    @GetMapping("/events/{productId}")
    public List<Object> getAllEvents(@PathVariable("productId") Integer productId) {
        return inventoryQueryService.listEventsForAccount(productId);
    }

    @GetMapping("/stats")
    public Map<Integer, Integer> getStats() {
        return inventoryStatsQueryService.getStatsView();
    }

    @GetMapping("/")
    public Map<Integer, Integer> getCurrentAmount() {
        return inventoryCurrentAmountQueryService.getCurrentAmount();
    }

}
