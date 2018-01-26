package windy.infrastructure.domains;

import windy.framework.core.domain.BaseAggregateRoot;
import windy.infrastructure.contracts.events.book.CreateBookEvent;
import windy.infrastructure.contracts.events.book.UpdateBookEvent;

public class Book extends BaseAggregateRoot{
    String title;
    String author;
    long publishedDate;
    long createdAt;
    boolean isActive;
    int count;

    public Book() {
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

    public long getCreatedAt() {
        return createdAt;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getCount() {
        return count;
    }

    private void updateGeneralInfo(String title, String author, long publishedDate){
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
    }

    private void apply(CreateBookEvent createBookEvent){
        this.uuid = createBookEvent.getUuid();
        this.title = createBookEvent.getTitle();
        this.author = createBookEvent.getTitle();
        this.publishedDate = System.currentTimeMillis();
        this.isActive = true;
        this.count = 1;
    }

    private void apply(UpdateBookEvent updateBookEvent){
        updateGeneralInfo(updateBookEvent.getTitle(),updateBookEvent.getAuthor(),updateBookEvent.getPublishedDate());
    }
}
