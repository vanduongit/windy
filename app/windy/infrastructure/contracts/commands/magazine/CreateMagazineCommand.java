package windy.infrastructure.contracts.commands.magazine;

import windy.infrastructure.contracts.commands.book.CreateBookCommand;
import windy.infrastructure.domains.Magazine;

public class CreateMagazineCommand extends MagazineCommand{

    private Magazine magazine;

    public CreateMagazineCommand(Magazine magazine){
        this.magazine = magazine;
    }

    @Override
    public void execute() {
        this.magazineRepository.create(magazine);
    }
}
