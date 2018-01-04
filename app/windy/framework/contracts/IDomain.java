package windy.framework.contracts;

import java.util.UUID;

public abstract class IDomain{
    protected String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}