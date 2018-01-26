package windy.infrastructure.commandhandlers.impl;

import windy.framework.infrastructure.eventsource.DomainRepository;
import windy.framework.infrastructure.eventsource.EventStorage;
import windy.infrastructure.commandhandlers.BookCommandHandler;
import windy.infrastructure.contracts.commands.book.UpdateBookCommand;
import windy.infrastructure.contracts.events.book.UpdatedGeneralInfoBookEvent;
import windy.infrastructure.domains.Book;

import javax.inject.Inject;

public class UpdateBookCommandHandler extends BookCommandHandler<UpdateBookCommand> {



    @Inject
    public UpdateBookCommandHandler(DomainRepository domainRepository, EventStorage eventStorage) {
        super(domainRepository,eventStorage);
    }

    @Override
    public void handle(UpdateBookCommand command) {

        Book book = new Book();
        book.loadFromHistory(getEventStorage().getAllEvents(command.getUuid()));

        UpdatedGeneralInfoBookEvent updatedGeneralInfoBookEvent = new UpdatedGeneralInfoBookEvent(command.getUuid(),
                book.getVersion()+1,
                command.getTitle(),
                command.getAuthor(),
                command.getPublishedDate());
        book.applyNewEvent(updatedGeneralInfoBookEvent);
        getDomainRepository().save(book);


    }
}
