package windy.infrastructure.contracts.commands.book;

import windy.infrastructure.contracts.commands.Command;
import windy.infrastructure.domains.Book;
import windy.infrastructure.repositories.BookRepository;

public class BookCommand extends Command{

    protected BookRepository bookRepository;


    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
