package ua.com.dudaryk.repository;

import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.repository.interfaces.IGenericDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class AbstractGenericDAOImpl<T> implements IGenericDAO<T> {
    private Class<T> clazz;

    @PersistenceContext
    public EntityManager entityManager;

    public void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    @Transactional(readOnly = true)
    public T findById(Long id) {
        return entityManager.find(clazz, id);
    }

    @Transactional(readOnly = true)
    public List findAll() {
        return entityManager.createQuery("from " + clazz.getName())
                .getResultList();
    }


    @Override
    @Transactional()
    public void create(T entity) {
        entityManager.merge(entity);
    }

    @Override
    @Transactional()
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    @Transactional()
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @Override
    @Transactional()
    public void save(T entity) {
        entityManager.persist(entity);
    }


}
