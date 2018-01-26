package windy.infrastructure.domains;

import windy.framework.core.domain.BaseAggregateRoot;
import windy.infrastructure.contracts.events.book.CreatedBookEvent;
import windy.infrastructure.contracts.events.book.DeletedBookEvent;
import windy.infrastructure.contracts.events.book.UpdatedGeneralInfoBookEvent;

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

    private void apply(CreatedBookEvent createdBookEvent){
        this.uuid = createdBookEvent.getUuid();
        this.title = createdBookEvent.getTitle();
        this.author = createdBookEvent.getTitle();
        this.publishedDate = System.currentTimeMillis();
        this.isActive = true;
        this.count = 1;
    }

    private void apply(UpdatedGeneralInfoBookEvent updatedGeneralInfoBookEvent){
        updateGeneralInfo(updatedGeneralInfoBookEvent.getTitle(), updatedGeneralInfoBookEvent.getAuthor(), updatedGeneralInfoBookEvent.getPublishedDate());
    }

    private void apply(DeletedBookEvent deletedBookEvent){

    }
}
