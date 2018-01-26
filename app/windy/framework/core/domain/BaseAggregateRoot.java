package windy.framework.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Throwables;
import windy.framework.contracts.IEvent;
import windy.framework.core.eventsource.IEventSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class BaseAggregateRoot extends IEventSource{

    private List<IEvent> newEvents;

    @Override
    public void markedAsCommitted() {

    }

    @Override
    public void loadFromHistory(List<IEvent> events) {
        events.forEach(event -> {
            applyEvent(event);
        });

    }

    @Override
    public void updateVersion(int version) {
        this.version = version;
    }

    @Override
    @JsonIgnore
    public List<IEvent> getChanges() {
        return newEvents;
    }

    public void applyNewEvent(IEvent event){
        applyEvent(event);
        if(newEvents == null){
            newEvents = new ArrayList<>();
        }
        newEvents.add(event);
    }

    private void applyEvent(IEvent event){
        try {
            Method method = this.getClass().getDeclaredMethod("apply", event.getClass());
            method.setAccessible(true);
            method.invoke(this, event);
            this.version = event.getVersion();
        } catch (InvocationTargetException e) {
            Throwables.propagate(e.getCause());
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new UnsupportedOperationException(
                    format("Aggregate '%s' doesn't apply event type '%s'", this.getClass(), event.getClass()), e);
        }
    }


}
