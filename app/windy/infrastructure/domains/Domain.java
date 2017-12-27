package windy.infrastructure.domains;

import windy.framework.contracts.IDomain;

import java.util.UUID;

public class Domain implements IDomain{

    private String uuid;

    public Domain(){
        uuid = UUID.randomUUID().toString();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
