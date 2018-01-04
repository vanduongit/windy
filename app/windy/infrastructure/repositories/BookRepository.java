package windy.infrastructure.repositories;

import org.springframework.stereotype.Repository;
import windy.framework.repository.IDomainRepository;
import windy.infrastructure.domains.Book;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class BookRepository extends BaseRepository<Book>{

    public BookRepository() {
        super(Book.class);
        Book book1 = new Book();
        book1.setUuid("234");
        book1.setTitle("book1");
        book1.setAuthor("duong1");
        book1.setCreatedAt(System.currentTimeMillis());
        book1.setPublishedDate(System.currentTimeMillis());
        book1.setActive(true);
        book1.setCount(1);
        list.add(book1);
    }
}
