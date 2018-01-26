package windy.infrastructure.contracts.events.book;

import windy.infrastructure.contracts.events.Event;

public class DeletedBookEvent extends Event{
    public DeletedBookEvent(String sourceId, int version) {
        super(sourceId, version);
    }
}
