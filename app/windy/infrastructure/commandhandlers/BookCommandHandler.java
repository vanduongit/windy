package windy.infrastructure.commandhandlers;

import windy.framework.core.ICommandHandler;
import windy.infrastructure.contracts.commands.book.BookCommand;
import windy.infrastructure.repositories.BookRepository;

import javax.inject.Inject;

public abstract class BookCommandHandler<T extends BookCommand> implements ICommandHandler<T>{

    private BookRepository bookRepository;

    @Inject
    protected BookCommandHandler(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }
}
