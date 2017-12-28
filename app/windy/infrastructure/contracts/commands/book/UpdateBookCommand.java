package windy.infrastructure.contracts.commands.book;

import windy.infrastructure.domains.Book;

public class UpdateBookCommand extends BookCommand{

    private Book book;

    public UpdateBookCommand(Book book){
        this.book = book;
    }

    @Override
    public void execute() {
        this.bookRepository.update(book);
    }

}
