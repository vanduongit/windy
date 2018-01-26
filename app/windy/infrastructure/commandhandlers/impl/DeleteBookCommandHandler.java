package windy.infrastructure.commandhandlers.impl;

import windy.framework.infrastructure.eventsource.DomainRepository;
import windy.framework.infrastructure.eventsource.EventStorage;
import windy.infrastructure.commandhandlers.BookCommandHandler;
import windy.infrastructure.contracts.commands.book.DeleteBookCommand;
import windy.infrastructure.contracts.commands.book.UpdateBookCommand;
import windy.infrastructure.contracts.events.book.DeletedBookEvent;
import windy.infrastructure.domains.Book;
import windy.infrastructure.repositories.BookRepository;

import javax.inject.Inject;

public class DeleteBookCommandHandler extends BookCommandHandler<DeleteBookCommand> {

    @Inject
    public DeleteBookCommandHandler(DomainRepository domainRepository, EventStorage eventStorage) {
        super(domainRepository,eventStorage);
    }


    @Override
    public void handle(DeleteBookCommand command) {
        Book book = new Book();
        book.loadFromHistory(getEventStorage().getAllEvents(command.getUuid()));
        DeletedBookEvent deletedBookEvent = new DeletedBookEvent(command.getUuid(),book.getVersion() + 1);
        book.applyNewEvent(deletedBookEvent);
        getDomainRepository().save(book);
    }
}
