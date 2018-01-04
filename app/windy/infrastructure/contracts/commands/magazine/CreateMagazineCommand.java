package windy.infrastructure.contracts.commands.magazine;

import windy.infrastructure.contracts.commands.book.CreateBookCommand;
import windy.infrastructure.domains.Magazine;

public class CreateMagazineCommand extends MagazineCommand{

    private Magazine magazine;


    public CreateMagazineCommand(String uuid) {
        super(uuid);
    }
}
