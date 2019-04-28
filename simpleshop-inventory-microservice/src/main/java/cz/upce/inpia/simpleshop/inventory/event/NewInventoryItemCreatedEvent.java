package cz.upce.inpia.simpleshop.inventory.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewInventoryItemCreatedEvent {

    private final Integer id;


}
