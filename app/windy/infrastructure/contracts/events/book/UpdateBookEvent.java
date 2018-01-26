package windy.infrastructure.contracts.events.book;

import windy.infrastructure.contracts.events.Event;

public class UpdateBookEvent extends Event{

    private String title;
    private String author;
    private long publishedDate;

    public UpdateBookEvent(String sourceId, int version, String title, String author, long publishedDate) {
        super(sourceId, version);
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public long getPublishedDate() {
        return publishedDate;
    }
}
