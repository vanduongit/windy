package windy.infrastructure.contracts.commands.book;

import windy.infrastructure.domains.Book;

public class DeleteBookCommand extends BookCommand{

    private String uuid;

    public DeleteBookCommand(String uuid){
        this.uuid = uuid;
    }

    @Override
    public void execute() {
        this.bookRepository.delete(uuid);
    }

}
