package ua.com.dudaryk.repository.realizations;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.repository.AbstractGenericDAOImpl;
import ua.com.dudaryk.repository.interfaces.ConcertDAO;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public class ConcertDAOImpl<Concert> extends AbstractGenericDAOImpl<Concert> implements ConcertDAO {


    @Override
    public void setClazz(Class<Concert> clazzToSet) {
        super.setClazz(clazzToSet);
    }

    @Transactional(readOnly = true)
    @Override
    public List findByName(String name) {
        String query = "select Concert from concert  where Concert.NAME=" + name;
        return entityManager.createQuery(query).getResultList();

    }

    @Transactional(readOnly = true)
    @Override
    public List findByDate(LocalDateTime date) {

        String query = "select Concert from concert  where Concert.DATE=" + date;
        return entityManager.createQuery(query).getResultList();

    }

    //???
    @Transactional(readOnly = true)
    @Override
    public List findByParticipant(Long id) {
        String query = "select Concert from concert  where Concert.PARTICIPANT_ID=" + id;
        return entityManager.createQuery(query).getResultList();
    }


}
