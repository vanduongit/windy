package windy.infrastructure.commandhandlers.impl;

import windy.infrastructure.commandhandlers.BookCommandHandler;
import windy.infrastructure.contracts.commands.book.CreateBookCommand;
import windy.infrastructure.domains.Book;
import windy.infrastructure.repositories.BookRepository;

import javax.inject.Inject;

public class CreateBookCommandHandler extends BookCommandHandler<CreateBookCommand> {

    @Inject
    public CreateBookCommandHandler(BookRepository bookRepository) {
        super(bookRepository);
    }


    @Override
    public void handle(CreateBookCommand command) {
        Book b = new Book();
        b.setUuid(command.getUuid());
        b.setTitle(command.getTitle());
        b.setAuthor(command.getAuthor());
        b.setCount(1);
        b.setCreatedAt(System.currentTimeMillis());
        b.setPublishedDate(System.currentTimeMillis());
        b.setActive(true);

        getBookRepository().create(b);

    }
}
