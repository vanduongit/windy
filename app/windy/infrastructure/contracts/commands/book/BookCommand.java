package windy.infrastructure.contracts.commands.book;

import windy.framework.contracts.ICommand;

public abstract class BookCommand extends ICommand{

    public BookCommand(String uuid) {
        super(uuid);
    }
}
