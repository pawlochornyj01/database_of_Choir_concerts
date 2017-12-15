package ua.com.dudaryk.repository.realizations;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.repository.AbstractGenericDAOImpl;
import ua.com.dudaryk.repository.interfaces.ParticipantDAO;

import java.util.List;

@Repository
@Transactional
public class ParticipantDAOImpl<Participant> extends AbstractGenericDAOImpl<Participant> implements ParticipantDAO {

    @Override
    public void setClazz(Class<Participant> clazzToSet) {
        super.setClazz(clazzToSet);
    }

    @Transactional(readOnly = true)
    @Override
    public List findByName(String name) {
        String query = "select Participant from participant  where Participant.NAME=" + name;
        return entityManager.createQuery(query).getResultList();
    }

//    @Transactional(readOnly = true)
//    @Override
//    public List findByConcert(Long id) {
//        String query = "select Participant from participant  where Participant.CONCERT_ID=" + id;
//        return entityManager.createQuery(query).getResultList();
//    }
}
