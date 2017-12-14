package ua.com.dudaryk.repository;

import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.Concert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class ConcertDAOImpl<Concert extends Serializable> extends AbstractDAO<Concert> implements ConcertDAO, IGenericDAO<Concert> {

//    @PersistenceContext
//    private EntityManager entityManager;


    @Override
    public void setClazz(Class<Concert> clazzToSet) {
        super.setClazz(clazzToSet);
    }

    @Transactional(readOnly = true)
    @Override
    public List findByName(String name) {
        String sql = "select Concert from concert  where Concert.NAME=" + name;
        return entityManager.createQuery(sql).getResultList();

    }

    @Transactional(readOnly = true)
    @Override
    public List findByDATE(LocalDateTime date) {

        String sql = "select Concert from concert  where Concert.DATE=" + date;
        return entityManager.createQuery(sql).getResultList();

    }


}
