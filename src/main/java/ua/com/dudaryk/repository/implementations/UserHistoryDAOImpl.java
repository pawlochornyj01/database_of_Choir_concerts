package ua.com.dudaryk.repository.implementations;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.repository.AbstractDAOImpl;
import ua.com.dudaryk.repository.interfaces.UserHistoryDAO;

import java.util.List;

@Repository
@Transactional
public class UserHistoryDAOImpl<UserHistory> extends AbstractDAOImpl<UserHistory> implements UserHistoryDAO {


    @Override
    public void setClazz(Class<UserHistory> clazzToSet) {
        super.setClazz(clazzToSet);
    }

    @Override
    public List findByDudarykId(Long id) {
        String query = "select UserHistory from user_history  where UserHistory.DUDARYK_ID=" + id;
        return entityManager.createQuery(query).getResultList();
    }


}
