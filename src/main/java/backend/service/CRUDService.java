package backend.service;

import java.util.List;

public interface CRUDService<T> {
    List<T> findAll();
    T findOne(int id);
    T save(T t);
    void delete(int id);
}