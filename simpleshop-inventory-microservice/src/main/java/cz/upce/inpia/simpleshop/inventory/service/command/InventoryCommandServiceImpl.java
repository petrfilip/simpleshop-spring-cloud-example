package cz.upce.inpia.simpleshop.inventory.service.command;

import cz.upce.inpia.simpleshop.inventory.command.CreateNewRepositoryItemCommand;
import cz.upce.inpia.simpleshop.inventory.command.DecreaseInventoryItemAmountCommand;
import cz.upce.inpia.simpleshop.inventory.command.IncreaseInventoryItemAmountCommand;
import cz.upce.inpia.simpleshop.inventory.dto.InventoryDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class InventoryCommandServiceImpl implements InventoryCommandService {

    private final CommandGateway commandGateway;

    public InventoryCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<Object> createInventoryItem(Integer productId) {
        CreateNewRepositoryItemCommand command = new CreateNewRepositoryItemCommand(productId);
        return commandGateway.send(command);
    }

    @Override
    public CompletableFuture<Object> increaseAmount(InventoryDto dto) {
        IncreaseInventoryItemAmountCommand command = new IncreaseInventoryItemAmountCommand(dto.getId(), dto.getAmount());
        return commandGateway.send(command);
    }

    @Override
    public CompletableFuture<Object> decreaseAmount(InventoryDto dto) {
        DecreaseInventoryItemAmountCommand command = new DecreaseInventoryItemAmountCommand(dto.getId(), dto.getAmount());
        return commandGateway.send(command);
    }

}
