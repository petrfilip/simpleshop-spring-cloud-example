package cz.upce.inpia.simpleshop.inventory.service.query;

import java.util.Map;

public interface InventoryCurrentAmountQueryService {
    Map<Integer, Integer> getCurrentAmount();
}
