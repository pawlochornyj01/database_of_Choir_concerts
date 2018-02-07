package ua.com.dudaryk.repository.implementations;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.Participant;
import ua.com.dudaryk.repository.AbstractDAOImpl;
import ua.com.dudaryk.repository.interfaces.ParticipantDAO;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
@Transactional
public class ParticipantDAOImpl extends AbstractDAOImpl<Participant> implements ParticipantDAO {

    @PostConstruct
    private void init() {
        setClazz(Participant.class);
    }

    @Override
    public void setClazz(Class<Participant> clazzToSet) {
        super.setClazz(clazzToSet);
    }

    @Override
    public Participant saveParticipant(Participant participant) {
        return save(participant);
    }

    @Override
    public void deleteParticipant(Participant participant) {
        super.delete(participant);
    }

    @Override
    public Participant findParticipantById(int id) {
        return findById(id);
    }

    @Override
    public List<Participant> findByName(String name) {
        String query = "select Participant from participant  where Participant.NAME=" + name;
        return entityManager.createQuery(query).getResultList();
    }


}
