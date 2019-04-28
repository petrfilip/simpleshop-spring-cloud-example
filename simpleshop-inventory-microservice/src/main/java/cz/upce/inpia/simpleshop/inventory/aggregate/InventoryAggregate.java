package cz.upce.inpia.simpleshop.inventory.aggregate;

import cz.upce.inpia.simpleshop.inventory.command.CreateNewRepositoryItemCommand;
import cz.upce.inpia.simpleshop.inventory.command.DecreaseInventoryItemAmountCommand;
import cz.upce.inpia.simpleshop.inventory.command.IncreaseInventoryItemAmountCommand;
import cz.upce.inpia.simpleshop.inventory.event.AmountDecreasedEvent;
import cz.upce.inpia.simpleshop.inventory.event.AmountIncreasedEvent;
import cz.upce.inpia.simpleshop.inventory.event.NewInventoryItemCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class InventoryAggregate {

    @AggregateIdentifier
    private Integer id;

    private Integer amount;

    //required by Axon
    protected InventoryAggregate() {
    }

    @CommandHandler
    public InventoryAggregate(CreateNewRepositoryItemCommand command) {
        AggregateLifecycle.apply(new NewInventoryItemCreatedEvent(command.getId()));
    }

    @EventSourcingHandler
    public void on(NewInventoryItemCreatedEvent event) {
        this.id = event.getId();
        this.amount = 0;
    }

    @CommandHandler
    public void handle(IncreaseInventoryItemAmountCommand command) {
        //todo validation
        AggregateLifecycle.apply(new AmountIncreasedEvent(command.getId(), command.getAmount()));
    }

    @EventSourcingHandler
    public void on(AmountIncreasedEvent event) {
        this.amount = this.amount + event.getAmount();
    }

    @CommandHandler
    public void handle(DecreaseInventoryItemAmountCommand command) {
        //todo validation
        AggregateLifecycle.apply(new AmountDecreasedEvent(command.getId(), command.getAmount()));
    }

    @EventSourcingHandler
    public void on(AmountDecreasedEvent event) {
        this.amount = this.amount - event.getAmount();
    }


}
