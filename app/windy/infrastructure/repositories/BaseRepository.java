package windy.infrastructure.repositories;

import windy.framework.contracts.IDomain;
import windy.framework.repository.IDomainRepository;
import windy.infrastructure.domains.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BaseRepository<T extends Domain> implements IDomainRepository<T>{

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
        return  list.stream().filter(e -> e.getUuid().equals(id)).findAny().orElse(null);
    }

    @Override
    public void create(T item) {
        list.add(item);
    }

    @Override
    public void update(T item) {
        list =  list.stream().filter(e -> !e.getUuid().equals(item.getUuid())).collect(Collectors.toList());
        list.add(item);
    }

    @Override
    public void delete(String uuid) {
        list =  list.stream().filter(e -> !e.getUuid().equals(uuid)).collect(Collectors.toList());
    }
}
