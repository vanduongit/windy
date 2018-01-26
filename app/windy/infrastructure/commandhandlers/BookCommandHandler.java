package windy.infrastructure.commandhandlers;

import windy.framework.core.messaging.ICommandHandler;
import windy.framework.infrastructure.eventsource.DomainRepository;
import windy.framework.infrastructure.eventsource.EventStorage;
import windy.infrastructure.contracts.commands.book.BookCommand;
import windy.infrastructure.repositories.BookRepository;

import javax.inject.Inject;

public abstract class BookCommandHandler<T extends BookCommand> implements ICommandHandler<T>{


    private DomainRepository domainRepository;
    private EventStorage eventStorage;

    public BookCommandHandler(DomainRepository domainRepository, EventStorage eventStorage) {
        this.domainRepository = domainRepository;
        this.eventStorage = eventStorage;
    }

    public DomainRepository getDomainRepository() {
        return domainRepository;
    }

    public EventStorage getEventStorage() {
        return eventStorage;
    }
}
