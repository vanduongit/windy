package windy.framework.core;

import windy.framework.contracts.ICommand;

public interface ICommandHandlerFactory {

    <T extends ICommand> ICommandHandler<T> createCommandHandler(Class<T> clazz);
}
