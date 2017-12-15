package ua.com.dudaryk.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Repository("concertDAO")
@Transactional
public class ConcertDAOImpl<Concert extends Serializable> extends AbstractGenericDAOImpl<Concert> implements ConcertDAO {


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
    public List findByDate(LocalDateTime date) {

        String sql = "select Concert from concert  where Concert.DATE=" + date;
        return entityManager.createQuery(sql).getResultList();

    }

    //???
    @Transactional(readOnly = true)
    @Override
    public List findByParticipant(Long id) {
        String sql = "select Concert from concert  where Concert.PARTICIPANT_ID=" + id;
        return entityManager.createQuery(sql).getResultList();
    }


}
