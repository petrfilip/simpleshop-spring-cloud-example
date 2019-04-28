package cz.upce.inpia.simpleshop.inventory.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AmountIncreasedEvent {

    private final Integer id;

    private Integer amount;
}
