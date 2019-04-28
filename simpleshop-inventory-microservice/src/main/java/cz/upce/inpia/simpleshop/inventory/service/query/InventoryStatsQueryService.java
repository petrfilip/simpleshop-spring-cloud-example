package cz.upce.inpia.simpleshop.inventory.service.query;

import java.util.Map;

public interface InventoryStatsQueryService {

    Map<Integer, Integer> getStatsView();
}
