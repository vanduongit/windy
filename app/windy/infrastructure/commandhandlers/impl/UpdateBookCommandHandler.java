package windy.infrastructure.commandhandlers.impl;

import windy.infrastructure.commandhandlers.BookCommandHandler;
import windy.infrastructure.contracts.commands.book.UpdateBookCommand;
import windy.infrastructure.domains.Book;
import windy.infrastructure.repositories.BookRepository;

import javax.inject.Inject;

public class UpdateBookCommandHandler extends BookCommandHandler<UpdateBookCommand> {


    @Inject
    public UpdateBookCommandHandler(BookRepository bookRepository) {
        super(bookRepository);
    }

    @Override
    public void handle(UpdateBookCommand command) {
        Book b = getBookRepository().getById(command.getUuid());
        if(b != null) {
            b.setTitle(command.getTitle());
            b.setAuthor(command.getAuthor());
            b.setCount(command.getCount());
            b.setCreatedAt(command.getCreatedAt());
            b.setPublishedDate(command.getPublishedDate());
            b.setActive(command.isActive());
            getBookRepository().update(b);
        }

    }
}
