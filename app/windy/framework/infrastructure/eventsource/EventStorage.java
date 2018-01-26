package windy.framework.infrastructure.eventsource;

import windy.framework.contracts.IEvent;
import windy.framework.core.eventsource.IEventSource;
import windy.framework.core.eventsource.IEventStorage;

import javax.inject.Singleton;
import java.util.*;

@Singleton
public class EventStorage implements IEventStorage{

    private Map<String,List<IEvent>> mapEvents;

    public EventStorage(){
        mapEvents = new HashMap<>();
    }

    @Override
    public boolean doesEventSourceExists(String aggregateId) {
        return mapEvents.containsKey(aggregateId);
    }

    @Override
    public List<IEvent> getAllEvents(String aggregateId) {
        return mapEvents.getOrDefault(aggregateId,new ArrayList<>());
    }

    @Override
    public void save(IEventSource source) {
        List<IEvent> listEvent = mapEvents.getOrDefault(source.getUuid(),new ArrayList<>());
        listEvent.addAll(source.getChanges());
        mapEvents.put(source.getUuid(),listEvent);
    }

    public Map<String, List<IEvent>> getMapEvents() {
        return mapEvents;
    }
}
