package ua.com.dudaryk.repository.implementations;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.Concert;
import ua.com.dudaryk.repository.AbstractDAOImpl;
import ua.com.dudaryk.repository.interfaces.ConcertDAO;

import javax.annotation.PostConstruct;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public class ConcertDAOImpl extends AbstractDAOImpl<Concert> implements ConcertDAO {

    @PostConstruct
    private void init() {
        setClazz(Concert.class);
    }

    @Override
    public Concert saveConcert(Concert concert) {
        return save(concert);
    }

    @Override
    public Concert updateConcert(Concert concert) {
        return update(concert);
    }

    @Override
    public void deleteConcert(Concert concert) {
        super.delete(concert);
    }

    @Override
    public Concert findConcertById(int id) {
        return findById(id);
    }

    @Override
    public List<Concert> findAllConcerts() {
        return findAll();
    }


    @Override
    public List<Concert> findByName(String name) {
        String query = "select Concert from concert  where Concert.NAME=" + name;
        return entityManager.createQuery(query).getResultList();

//             createNativeQuery(query).getResultList();

    }


    @Override
    public List<Concert> findByDate(LocalDateTime date) {
        String query = "select Concert from concert  where Concert.DATE=" + date;
        return entityManager.createQuery(query).getResultList();

    }


    @Override
    public List<Concert> findByParticipant(int id) {
        TypedQuery<Concert> query = entityManager.createQuery(
                "select c from Concert c " +
                        "join c.participants p where p.participantId= :id", Concert.class);
        return query.setParameter("id", id).getResultList();

    }

    @Override
    public List<Concert> findByDudarykId(int id) {
        TypedQuery<Concert> query = entityManager.createQuery(
                "select c from Concert c " +
                        "join c.dudaryks d where d.dudarykId = :id", Concert.class);
        return query.setParameter("id", id).getResultList();
    }


}
