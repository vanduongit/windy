package windy.framework.infrastructure.messaging;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import com.google.inject.util.Types;
import windy.framework.contracts.ICommand;
import windy.framework.core.ICommandHandler;
import windy.framework.core.ICommandHandlerFactory;
import windy.infrastructure.commandhandlers.BookCommandHandler;
import windy.infrastructure.commandhandlers.MagazineCommandHandler;
import windy.infrastructure.contracts.commands.book.BookCommand;
import windy.infrastructure.contracts.commands.magazine.MagazineCommand;
import windy.infrastructure.domains.Magazine;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

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
