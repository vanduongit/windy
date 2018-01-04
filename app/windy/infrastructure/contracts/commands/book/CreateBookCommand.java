package windy.infrastructure.contracts.commands.book;

import windy.infrastructure.domains.Book;

public class CreateBookCommand extends BookCommand{

    private String title;
    private String author;

    public CreateBookCommand(String uuid, String title, String author) {
        super(uuid);
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
