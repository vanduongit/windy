package windy.infrastructure.repositories;

import windy.framework.contracts.IDomain;
import windy.framework.repository.IDomainRepository;

import java.util.ArrayList;
import java.util.List;

public class BaseRepository<T extends IDomain> implements IDomainRepository<T>{

    Class<T> clazz;
    protected List<T> list;

    public BaseRepository(Class<T> clazz){
        this.clazz = clazz;
        list = new ArrayList<>();
    }

    @Override
    public List<T> getAll() {
        return list;
    }

    @Override
    public T getById(String id) {
        return null;
    }

    @Override
    public void create(T item) {
        list.add(item);
    }

    @Override
    public void update(T item) {

    }

    @Override
    public void delete(T item) {

    }
}
