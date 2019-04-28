package cz.upce.inpia.simpleshop.inventory.service.query;

import cz.upce.inpia.simpleshop.inventory.event.AmountDecreasedEvent;
import cz.upce.inpia.simpleshop.inventory.event.AmountIncreasedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class InventoryCurrentAmountQueryServiceImpl implements InventoryCurrentAmountQueryService {

    private ConcurrentMap<Integer, Integer> database = new ConcurrentHashMap<>();

    @EventHandler
    public void on(AmountIncreasedEvent event) {
        Integer currentAmount = database.getOrDefault(event.getId(), 0);
        database.put(event.getId(), currentAmount + event.getAmount());
    }

    @EventHandler
    public void on(AmountDecreasedEvent event) {
        Integer currentAmount = database.getOrDefault(event.getId(), 0);
        database.put(event.getId(), currentAmount - event.getAmount());
    }

    @Override
    @QueryHandler
    public Map<Integer, Integer> getCurrentAmount() {
        return database;
    }
}
