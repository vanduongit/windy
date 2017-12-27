package windy.infrastructure.commandhandlers;

import windy.framework.core.ICommandHandler;
import windy.infrastructure.contracts.commands.book.BookCommand;
import windy.infrastructure.repositories.BookRepository;

import javax.inject.Inject;

public class BookCommandHandler<T extends BookCommand> implements ICommandHandler<T>{

    private BookRepository bookRepository;

    @Inject
    BookCommandHandler(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public void handle(T command) {
        command.setBookRepository(bookRepository);
        command.execute();
    }
}
