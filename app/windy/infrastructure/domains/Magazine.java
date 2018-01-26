package windy.infrastructure.domains;

import windy.framework.contracts.IDomain;
import windy.framework.core.domain.BaseAggregateRoot;

public class Magazine extends IDomain{

    String title;
    String author;
    long publishedDate;
    long createdAt;
    boolean isActive;
    int count;

    public Magazine() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(long publishedDate) {
        this.publishedDate = publishedDate;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
