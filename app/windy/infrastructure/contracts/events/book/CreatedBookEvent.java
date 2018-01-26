package windy.infrastructure.contracts.events.book;

import windy.infrastructure.contracts.events.Event;

public class CreatedBookEvent extends Event{

    private String title;
    private String author;

    public CreatedBookEvent(String sourceId, int version, String title, String author) {
        super(sourceId,version);
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
