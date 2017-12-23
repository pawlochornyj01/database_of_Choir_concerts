package ua.com.dudaryk.service.interfaces;

import java.util.List;

public interface AbstractService<T> {
    T findById(Long id);

    T save(T entity);

    T update(T entity);

    void delete(Long id);

    List findAll();
}
