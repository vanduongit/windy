package windy.framework.infrastructure.messaging;

import windy.framework.contracts.ICommand;
import windy.framework.core.ICommandHandler;
import windy.framework.core.ICommandHandlerFactory;
import windy.infrastructure.commandhandlers.BookCommandHandler;
import windy.infrastructure.commandhandlers.MagazineCommandHandler;
import windy.infrastructure.contracts.commands.book.BookCommand;
import windy.infrastructure.contracts.commands.magazine.MagazineCommand;
import windy.infrastructure.domains.Magazine;

import javax.inject.Inject;

public class CommandHandlerFactory implements ICommandHandlerFactory{

    private BookCommandHandler bookCommandHandler;
    private MagazineCommandHandler magazineCommandHandler;

    @Inject
    public CommandHandlerFactory(BookCommandHandler bookCommandHandler, MagazineCommandHandler magazineCommandHandler) {
        this.bookCommandHandler = bookCommandHandler;
        this.magazineCommandHandler = magazineCommandHandler;
    }

    @Override
    public <T extends ICommand> ICommandHandler<T> createCommandHandler(Class<T> clazz) {

        if(BookCommand.class.isAssignableFrom(clazz)){
            return bookCommandHandler;
        }else if(MagazineCommand.class.isAssignableFrom(clazz)){
            return magazineCommandHandler;
        }

        return null;
    }


}
