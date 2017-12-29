package windy.infrastructure.contracts.commands.magazine;


public class DeleteMagazineCommand extends MagazineCommand{

    private String uuid;

    public DeleteMagazineCommand(String uuid){
        this.uuid = uuid;
    }

    @Override
    public void execute() {
        this.magazineRepository.delete(uuid);
    }

}
