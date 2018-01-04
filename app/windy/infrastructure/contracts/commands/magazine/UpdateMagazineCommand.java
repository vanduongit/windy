package windy.infrastructure.contracts.commands.magazine;

import windy.infrastructure.domains.Magazine;

public class UpdateMagazineCommand extends MagazineCommand{

    private Magazine magazine;


    public UpdateMagazineCommand(String uuid) {
        super(uuid);
    }
}
