package cz.upce.inpia.simpleshop.inventory.service.query;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryQueryServiceImpl implements InventoryQueryService {

    private final EventStore eventStore;

    public InventoryQueryServiceImpl(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @Override
    public List<Object> listEventsForAccount(Integer productId) {
        return eventStore.readEvents(String.valueOf(productId)).asStream().map(s -> s.getPayload()).collect(Collectors.toList());
    }

}
