package windy.framework.contracts;

import java.util.UUID;

public abstract class IEvent {
    private String uuid;
    private String sourceId;
    private int version;

    public IEvent(String sourceId, int version) {
        uuid = UUID.randomUUID().toString();
        this.sourceId = sourceId;
        this.version = version;
    }

    public String getUuid() {
        return uuid;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
