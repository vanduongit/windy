package windy.framework.core;

import windy.framework.contracts.ICommand;

public interface ICommandHandler<T extends ICommand>{
    void handle(T command);
}