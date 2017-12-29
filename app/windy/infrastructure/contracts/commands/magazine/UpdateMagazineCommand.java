package windy.infrastructure.contracts.commands.magazine;

import windy.infrastructure.domains.Magazine;

public class UpdateMagazineCommand extends MagazineCommand{

    private Magazine magazine;

    public UpdateMagazineCommand(Magazine magazine){
        this.magazine = magazine;
    }

    @Override
    public void execute() {
        this.magazineRepository.update(magazine);
    }

}
