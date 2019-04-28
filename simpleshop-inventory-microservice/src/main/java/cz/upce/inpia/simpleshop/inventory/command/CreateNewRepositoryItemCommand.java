package cz.upce.inpia.simpleshop.inventory.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
public class CreateNewRepositoryItemCommand {

    @TargetAggregateIdentifier
    private final Integer id;

}
