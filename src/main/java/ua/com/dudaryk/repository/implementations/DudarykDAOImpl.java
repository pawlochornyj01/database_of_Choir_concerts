package ua.com.dudaryk.repository.implementations;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.Dudaryk;
import ua.com.dudaryk.model.Voice;
import ua.com.dudaryk.repository.AbstractDAOImpl;
import ua.com.dudaryk.repository.interfaces.DudarykDAO;

import javax.annotation.PostConstruct;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class DudarykDAOImpl extends AbstractDAOImpl<Dudaryk> implements DudarykDAO {

    @PostConstruct
    private void init() {
        setClazz(Dudaryk.class);
    }

    @Override
    public void setClazz(Class<Dudaryk> clazzToSet) {
        super.setClazz(clazzToSet);
    }

    @Override
    public Dudaryk saveDudaryk(Dudaryk dudaryk) {
        return save(dudaryk);
    }

    @Override
    public Dudaryk updateDudaryk(Dudaryk dudaryk) {
        return update(dudaryk);
    }

    @Override
    public void deleteDudaryk(Dudaryk dudaryk) {
        super.delete(dudaryk);
    }

    @Override
    public Dudaryk findDudarykById(int id) {
        return findById(id);
    }

    @Override
    public List<Dudaryk> findAllDudaryks() {
        return findAll();
    }


    @Override
    public List<Dudaryk> findByName(String name) {
        TypedQuery<Dudaryk> query = entityManager.createQuery(
                "select d from Dudaryk d " +
                        " where d.name= :name", Dudaryk.class);
        return query.setParameter("name", name).getResultList();
    }


    @Override
    public List<Dudaryk> findByLastName(String lastName) {
        TypedQuery<Dudaryk> query = entityManager.createQuery(
                "select d from Dudaryk d " +
                        " where d.lastName= :lastName", Dudaryk.class);
        return query.setParameter("lastName", lastName).getResultList();
    }


    @Override
    public List<Dudaryk> findByVoice(Voice voice) {
        TypedQuery<Dudaryk> query = entityManager.createQuery(
                "select d from Dudaryk d " +
                        " where d.voice= :voice", Dudaryk.class);
        return query.setParameter("voice", voice).getResultList();
    }


    @Override
    public List<Dudaryk> findAction() {
        TypedQuery<Dudaryk> query = entityManager.createQuery(
                "select d from Dudaryk d " +
                        " where d.isAction= :true", Dudaryk.class);
        return query.getResultList();
    }


    @Override
    public List<Dudaryk> findByConcert(int id) {
        TypedQuery<Dudaryk> query = entityManager.createQuery(
                "select d from Dudaryk d " +
                        "join d.concerts c where c.concertId= :id", Dudaryk.class);
        return query.setParameter("id", id).getResultList();
    }
}
