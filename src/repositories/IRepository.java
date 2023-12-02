package repositories;

import java.util.List;

public interface IRepository<T> {
    List<T> findAll();

    void create(T model);

    void remove(T model);
}
