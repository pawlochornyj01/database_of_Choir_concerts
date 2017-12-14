package ua.com.dudaryk.repository;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T extends Serializable> {

    T findById(Long id);

    List<T> findAll();

    void create(T entity);

    void update(T entity);

    void delete(T entity);

    void save(T entity);


}
