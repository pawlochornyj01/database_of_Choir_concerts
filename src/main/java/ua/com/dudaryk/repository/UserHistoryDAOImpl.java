package ua.com.dudaryk.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository("userHistoryDAO")
@Transactional
public class UserHistoryDAOImpl<UserHistory extends Serializable> extends AbstractGenericDAOImpl<UserHistory> implements UserHistoryDAO {


    @Override
    public void setClazz(Class<UserHistory> clazzToSet) {
        super.setClazz(clazzToSet);
    }

    @Override
    public List findByDudarykId(Long id) {
        String sql = "select UserHistory from user_history  where UserHistory.DUDARYK_ID=" + id;
        return entityManager.createQuery(sql).getResultList();
    }


}
