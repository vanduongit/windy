package windy.framework.core;

import windy.framework.contracts.ICommand;

public interface ICommandBus{

    <T extends ICommand> void send(T command, Class<T> clazz);
}