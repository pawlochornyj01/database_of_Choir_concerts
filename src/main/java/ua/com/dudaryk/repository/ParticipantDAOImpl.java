package ua.com.dudaryk.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository("participantDAO")
@Transactional
public class ParticipantDAOImpl<Participant extends Serializable> extends AbstractGenericDAOImpl<Participant> implements ParticipantDAO {

    @Override
    public void setClazz(Class<Participant> clazzToSet) {
        super.setClazz(clazzToSet);
    }

    @Transactional(readOnly = true)
    @Override
    public List findByName(String name) {
        String sql = "select Participant from participant  where Participant.NAME=" + name;
        return entityManager.createQuery(sql).getResultList();
    }

//    @Transactional(readOnly = true)
//    @Override
//    public List findByConcert(Long id) {
//        String sql = "select Participant from participant  where Participant.CONCERT_ID=" + id;
//        return entityManager.createQuery(sql).getResultList();
//    }
}
