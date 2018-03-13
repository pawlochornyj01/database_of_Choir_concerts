package ua.com.dudaryk.repository.implementations;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.UserHistory;
import ua.com.dudaryk.repository.AbstractDAOImpl;
import ua.com.dudaryk.repository.interfaces.UserHistoryDAO;

import javax.annotation.PostConstruct;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UserHistoryDAOImpl extends AbstractDAOImpl<UserHistory> implements UserHistoryDAO {

    @PostConstruct
    private void init() {
        setClazz(UserHistory.class);
    }

    @Override
    public List<UserHistory> findByDudarykId(int id) {
        TypedQuery<UserHistory> query = entityManager.createQuery(
                "select uh from UserHistory uh " +
                        "join uh.dudaryk d where d.dudarykId= :id", UserHistory.class);
        return query.setParameter("id", id).getResultList();
    }

    @Override
    public List<UserHistory> findAllUserHistory() {
        return findAll();
    }

    @Override
    public UserHistory saveUserHistory(UserHistory userHistory) {
        return save(userHistory);
    }

    @Override
    public UserHistory updateUserHistory(UserHistory userHistory) {
        return update(userHistory);
    }

    @Override
    public UserHistory findByIdUserHistory(int id) {
        return findById(id);
    }

    @Override
    public void deleteUserHistory(UserHistory userHistory) {
        super.delete(userHistory);
    }


}
