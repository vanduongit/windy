package windy.framework.core.repository;

import windy.framework.contracts.IDomain;

import java.util.List;

public interface IReadRepository<T extends IDomain> {

    List<T> getAll();
    T getById(String id);
    void create(T item);
    void update(T item);
    void delete(String uuid);

}
