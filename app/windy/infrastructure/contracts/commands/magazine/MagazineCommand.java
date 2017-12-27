package windy.infrastructure.contracts.commands.magazine;

import windy.infrastructure.contracts.commands.Command;
import windy.infrastructure.repositories.MagazineRepository;

public class MagazineCommand extends Command{

    protected MagazineRepository magazineRepository;

    public void setMagazineRepository(MagazineRepository magazineRepository) {
        this.magazineRepository = magazineRepository;
    }
}
