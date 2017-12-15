package ua.com.dudaryk.repository.implementations;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.repository.AbstractDAOImpl;
import ua.com.dudaryk.repository.interfaces.CommunicationDAO;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public class AbstractDAOImpl<Communication> extends AbstractDAOImpl<Communication> implements CommunicationDAO {

    @Override
    public void setClazz(Class<Communication> clazzToSet) {
        super.setClazz(clazzToSet);
    }

    @Transactional(readOnly = true)
    @Override
    public List findByConcertId(Long id) {
        String query = "select Communication from communication  where Communication.CONCERT_ID=" + id;
        return entityManager.createQuery(query).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List findByMembershipDate(LocalDateTime date) {
        String query = "select Communication from communication  where Communication.DATE_OF_MEMBERSHIP=" + date;
        return entityManager.createQuery(query).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List findByName(String name) {
        String query = "select Communication from communication  where Communication.NAME=" + name;
        return entityManager.createQuery(query).getResultList();
    }
}
