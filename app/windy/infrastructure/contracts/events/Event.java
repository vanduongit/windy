package windy.infrastructure.contracts.events;

import windy.framework.contracts.IEvent;

public abstract class Event extends IEvent{
    public Event(String sourceId, int version) {
        super(sourceId, version);
    }
}
