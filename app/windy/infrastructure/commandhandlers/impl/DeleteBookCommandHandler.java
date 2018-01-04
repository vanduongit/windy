package windy.infrastructure.commandhandlers.impl;

import windy.infrastructure.commandhandlers.BookCommandHandler;
import windy.infrastructure.contracts.commands.book.DeleteBookCommand;
import windy.infrastructure.contracts.commands.book.UpdateBookCommand;
import windy.infrastructure.domains.Book;
import windy.infrastructure.repositories.BookRepository;

import javax.inject.Inject;

public class DeleteBookCommandHandler extends BookCommandHandler<DeleteBookCommand> {

    @Inject
    public DeleteBookCommandHandler(BookRepository bookRepository) {
        super(bookRepository);
    }


    @Override
    public void handle(DeleteBookCommand command) {

        getBookRepository().delete(command.getUuid());

    }
}
