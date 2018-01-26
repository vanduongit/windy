package windy.framework.core.eventsource;

import windy.framework.contracts.IEvent;

import java.util.List;

public interface IEventStorage {
    boolean doesEventSourceExists(String id);
    List<IEvent> getAllEvents(String sourceId);
    void save(IEventSource source);
}
