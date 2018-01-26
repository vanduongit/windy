package windy.infrastructure.commandhandlers;

import windy.framework.core.messaging.ICommandHandler;
import windy.infrastructure.contracts.commands.magazine.MagazineCommand;
import windy.infrastructure.repositories.MagazineRepository;

import javax.inject.Inject;

public class MagazineCommandHandler<T extends MagazineCommand> implements ICommandHandler<T> {

    private MagazineRepository magazineRepository;

    @Inject
    public MagazineCommandHandler(MagazineRepository magazineRepository){
        this.magazineRepository = magazineRepository;
    }

    @Override
    public void handle(T command) {

    }
}
