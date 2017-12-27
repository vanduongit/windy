package windy.infrastructure.contracts.commands.book;

import windy.infrastructure.domains.Book;

public class CreateBookCommand extends BookCommand{

    private Book book;

    public CreateBookCommand(Book book){
        this.book = book;
    }

    @Override
    public void execute() {
        this.bookRepository.create(book);
    }

}
