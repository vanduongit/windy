package windy.infrastructure.contracts.commands.magazine;

import windy.framework.contracts.ICommand;

public class MagazineCommand extends ICommand{


    public MagazineCommand(String uuid) {
        super(uuid);
    }
}
