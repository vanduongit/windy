package windy.framework.repository;

import windy.framework.contracts.IDomain;

import java.util.List;

public interface IDomainRepository<T extends IDomain> {

    List<T> getAll();
    T getById(String id);
    void create(T item);
    void update(T item);
    void delete(T item);

}
