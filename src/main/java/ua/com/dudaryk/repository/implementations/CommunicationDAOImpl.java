package ua.com.dudaryk.repository.implementations;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.Communication;
import ua.com.dudaryk.repository.AbstractDAOImpl;
import ua.com.dudaryk.repository.interfaces.CommunicationDAO;

import javax.annotation.PostConstruct;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public class CommunicationDAOImpl extends AbstractDAOImpl<Communication> implements CommunicationDAO {

    @PostConstruct
    private void init() {
        setClazz(Communication.class);
    }

    @Override
    public Communication findByCommunicationId(int id) {
        return findById(id);
    }

    @Override
    public Communication saveCommunication(Communication communication) {
        return save(communication);
    }

    @Override
    public Communication updateCommunication(Communication communication) {
        return update(communication);
    }

    @Override
    public void deleteCommunication(Communication communication) {
        super.delete(communication);
    }

    @Override
    public List<Communication> findAllCommunication() {
        return findAll();
    }


    @Override
    public List<Communication> findByConcertId(int id) {
        TypedQuery<Communication> query = entityManager.createQuery(
                "select cm from Communication cm " +
                        "join cm.concert ct where ct.concertId= :id", Communication.class);
        return query.setParameter("id", id).getResultList();
    }


    @Override
    public List<Communication> findByMembershipDate(LocalDateTime date) {
        TypedQuery<Communication> query = entityManager.createQuery(
                "select cm from Communication cm " +
                        " where cm.membershipDate= :date", Communication.class);
        return query.setParameter("date", date).getResultList();
    }


    @Override
    public List<Communication> findByName(String name) {
        TypedQuery<Communication> query = entityManager.createQuery(
                "select cm from Communication cm " +
                        " where cm.name= :name", Communication.class);
        return query.setParameter("name", name).getResultList();
    }
}
