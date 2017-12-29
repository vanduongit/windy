package windy.infrastructure.repositories;

import windy.infrastructure.domains.Magazine;

import javax.inject.Singleton;


@Singleton
public class MagazineRepository extends BaseRepository<Magazine>{


    public MagazineRepository() {
        super(Magazine.class);
        Magazine magazine = new Magazine();
        magazine.setTitle("magazine1");
        magazine.setAuthor("duong1");
        magazine.setCreatedAt(System.currentTimeMillis());
        magazine.setPublishedDate(System.currentTimeMillis());
        magazine.setActive(true);
        magazine.setCount(2);
        list.add(magazine);
    }

}
