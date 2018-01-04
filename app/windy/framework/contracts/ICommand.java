package windy.framework.contracts;


public abstract class ICommand{

    private String uuid;

    public ICommand(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

}