package windy.framework.core.messaging;

import windy.framework.contracts.ICommand;

public interface ICommandHandler<T extends ICommand>{
    void handle(T command);
}