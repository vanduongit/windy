package windy.framework.core.eventsource;

import windy.framework.contracts.IEvent;

import java.util.List;

public abstract class IEventSource {
    protected String uuid;
    protected int version;

    public String getUuid() {
        return uuid;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public abstract void markedAsCommitted();
    public abstract void loadFromHistory(List<IEvent> events);
    public abstract void updateVersion(int version);
    public abstract List<IEvent> getChanges();

}
