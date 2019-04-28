package cz.upce.inpia.simpleshop.inventory.service.query;

import java.util.List;

public interface InventoryQueryService {
    List<Object> listEventsForAccount(Integer productId);
}
