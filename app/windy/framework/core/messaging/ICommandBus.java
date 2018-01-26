package windy.framework.core.messaging;

import windy.framework.contracts.ICommand;

public interface ICommandBus{

    <T extends ICommand> void send(T command);
}