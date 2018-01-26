package windy.framework.infrastructure.messaging;

import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import windy.framework.contracts.ICommand;
import windy.framework.core.messaging.ICommandHandler;
import windy.framework.core.messaging.ICommandHandlerFactory;

import javax.inject.Inject;

public class CommandHandlerFactory implements ICommandHandlerFactory{


    private Injector injector;

    @Inject
    public CommandHandlerFactory(Injector injector) {
        this.injector = injector;
    }

    @Override
    public <T extends ICommand> ICommandHandler<T> createCommandHandler(T command) {
        String[] classNames = command.getClass().getName().split("\\.");
        ICommandHandler<T> handler = (ICommandHandler<T>)injector.getInstance(
                Key.get(ICommandHandler.class, Names.named(classNames[classNames.length-1]+"Handler")));
        return handler;
    }


}
