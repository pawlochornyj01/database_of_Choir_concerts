package ua.com.dudaryk.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Repository("communicationDAO")
@Transactional
public class CommunicationDAOImpl<Communication extends Serializable> extends AbstractGenericDAOImpl<Communication> implements CommunicationDAO {

    @Override
    public void setClazz(Class<Communication> clazzToSet) {
        super.setClazz(clazzToSet);
    }

    @Transactional(readOnly = true)
    @Override
    public List findByConcertId(Long id) {
        String sql = "select Communication from communication  where Communication.CONCERT_ID=" + id;
        return entityManager.createQuery(sql).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List findByMembershipDate(LocalDateTime date) {
        String sql = "select Communication from communication  where Communication.DATE_OF_MEMBERSHIP=" + date;
        return entityManager.createQuery(sql).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List findByName(String name) {
        String sql = "select Communication from communication  where Communication.NAME=" + name;
        return entityManager.createQuery(sql).getResultList();
    }
}
