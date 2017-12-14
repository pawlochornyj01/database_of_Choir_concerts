package ua.com.dudaryk.repository;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractDAO< T extends Serializable>  {
    private Class< T > clazz;

    @PersistenceContext
    EntityManager entityManager;

    public void setClazz( Class< T > clazzToSet ) {
        this.clazz = clazzToSet;
    }

    @Transactional(readOnly=true)
    public T findById( Long id ){
        return entityManager.find( clazz, id );
    }
    @Transactional(readOnly=true)
    public List findAll(){
        return entityManager.createQuery( "from " + clazz.getName() )
                .getResultList();
    }

    @Transactional(readOnly=false)
    public void create(T entity) {
        entityManager.merge(entity);
    }


    @Transactional(readOnly=false)
    public void update( T entity ){
        entityManager.merge( entity );
    }

    @Transactional(readOnly=false)
    public void delete( T entity ){
        entityManager.remove( entity );
    }

    @Transactional(readOnly=false)
    public void save( T entity ){
        entityManager.persist( entity );
    }


}
