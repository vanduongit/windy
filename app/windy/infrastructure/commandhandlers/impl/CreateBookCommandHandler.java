package windy.infrastructure.commandhandlers.impl;

import windy.framework.infrastructure.eventsource.DomainRepository;
import windy.framework.infrastructure.eventsource.EventStorage;
import windy.infrastructure.commandhandlers.BookCommandHandler;
import windy.infrastructure.contracts.commands.book.CreateBookCommand;
import windy.infrastructure.contracts.events.book.CreateBookEvent;
import windy.infrastructure.domains.Book;
import windy.infrastructure.repositories.BookRepository;

import javax.inject.Inject;

public class CreateBookCommandHandler extends BookCommandHandler<CreateBookCommand> {

    @Inject
    public CreateBookCommandHandler(DomainRepository domainRepository, EventStorage eventStorage) {
        super(domainRepository,eventStorage);
    }


    @Override
    public void handle(CreateBookCommand command) {
        Book b = new Book();
        CreateBookEvent createBookEvent = new CreateBookEvent(command.getUuid(),1,command.getTitle(),command.getAuthor());
        b.applyNewEvent(createBookEvent);
        getDomainRepository().save(b);

    }
}
