package windy.framework.infrastructure.messaging;


import windy.framework.contracts.ICommand;
import windy.framework.core.ICommandBus;
import windy.framework.core.ICommandHandlerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CommandBus implements ICommandBus{


    ICommandHandlerFactory commandHandlerFactory;

    @Inject
    public CommandBus(ICommandHandlerFactory commandHandlerFactory){
        this.commandHandlerFactory = commandHandlerFactory;
    }

    @Override
    public <T extends ICommand> void send(T command, Class<T> clazz){

        commandHandlerFactory.createCommandHandler(clazz).handle(command);
    }


}
