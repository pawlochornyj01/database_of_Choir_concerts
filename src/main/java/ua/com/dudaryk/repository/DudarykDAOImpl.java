package ua.com.dudaryk.repository;

import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.Voice;

import java.io.Serializable;
import java.util.List;

public class DudarykDAOImpl<Dudaryk extends Serializable> extends AbstractDAO<Dudaryk> implements DudarykDAO, IGenericDAO<Dudaryk> {

    @Override
    public void setClazz(Class<Dudaryk> clazzToSet) {
        super.setClazz(clazzToSet);
    }

    @Transactional(readOnly = true)
    @Override
    public List findByName(String name) {
        String sql = "select Dudaryk from dudaryk  where Dudaryk.NAME=" + name;
        return entityManager.createQuery(sql).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List findByLastName(String lastName) {
        String sql = "select Dudaryk from dudaryk  where Dudaryk.LASTNAME=" + lastName;
        return entityManager.createQuery(sql).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List findByVoice(String voice) {
        String sql = "select Dudaryk from dudaryk  where Dudaryk.VOICE=" + Voice.valueOf(voice);
        return entityManager.createQuery(sql).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List findAction() {
        String sql = "select Dudaryk from dudaryk  where Dudaryk.IS_ACTION=" + true;
        return entityManager.createQuery(sql).getResultList();
    }
}
