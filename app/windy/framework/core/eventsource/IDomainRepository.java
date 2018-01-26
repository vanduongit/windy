package windy.framework.core.eventsource;

public interface IDomainRepository {

    <T extends IEventSource> T getById(String id);
    boolean doesExist(String id);
    <T extends IEventSource> void save(T aggregate);
}
