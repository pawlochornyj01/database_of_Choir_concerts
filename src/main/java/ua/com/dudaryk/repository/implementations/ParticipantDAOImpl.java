package ua.com.dudaryk.repository.implementations;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.Concert;
import ua.com.dudaryk.model.Participant;
import ua.com.dudaryk.repository.AbstractDAOImpl;
import ua.com.dudaryk.repository.interfaces.ParticipantDAO;

import javax.annotation.PostConstruct;
import javax.persistence.TypedQuery;
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
        TypedQuery<Participant> query = entityManager.createQuery(
                "select p from Participant p " +
                        "where p.name= :name", Participant.class);
        return query.setParameter("name", name).getResultList();
    }

    @Override
    public List<Participant> findByConcertId(int id) {
        TypedQuery<Participant> query = entityManager.createQuery(
                "select p from Participant p " +
                        "join p.concerts c where c.concertId= :id", Participant.class);
        return query.setParameter("id", id).getResultList();
    }

    @Override
    public List<Participant> findAllParticipant() {
        return findAll();
    }


}
