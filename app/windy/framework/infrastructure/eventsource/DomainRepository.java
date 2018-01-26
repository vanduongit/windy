package windy.framework.infrastructure.eventsource;

import windy.framework.core.eventsource.IDomainRepository;
import windy.framework.core.eventsource.IEventSource;
import windy.framework.core.eventsource.IEventStorage;

import javax.inject.Inject;

public class DomainRepository implements IDomainRepository {

    private IEventStorage eventStorage;

    @Inject
    public DomainRepository(IEventStorage eventStorage){
        this.eventStorage = eventStorage;
    }

    @Override
    public <T extends IEventSource> T getById(String id) {
        return null;
    }

    @Override
    public boolean doesExist(String aggregateId) {
        return eventStorage.doesEventSourceExists(aggregateId);
    }

    @Override
    public <T extends IEventSource> void save(T aggregate) {
        eventStorage.save(aggregate);
    }
}
