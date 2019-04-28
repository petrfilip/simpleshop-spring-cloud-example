package cz.upce.inpia.simpleshop.inventory.service.query;

import cz.upce.inpia.simpleshop.inventory.event.AmountIncreasedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class InventoryStatsQueryServiceImpl implements InventoryStatsQueryService {

    private ConcurrentMap<Integer, Integer> statistics = new ConcurrentHashMap<>();

    @EventHandler
    public void on(AmountIncreasedEvent event) {
        int count = statistics.getOrDefault(event.getId(), 0);
        statistics.put(event.getId(), count + 1);
    }

    @Override
    @QueryHandler
    public Map<Integer, Integer> getStatsView() {
        return statistics;
    }
}
