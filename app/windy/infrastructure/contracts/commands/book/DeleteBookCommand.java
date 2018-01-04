package windy.infrastructure.contracts.commands.book;


public class DeleteBookCommand extends BookCommand{

    public DeleteBookCommand(String uuid) {
        super(uuid);
    }
}
