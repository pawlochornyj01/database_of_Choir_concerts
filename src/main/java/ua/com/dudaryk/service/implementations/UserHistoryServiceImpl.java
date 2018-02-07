package ua.com.dudaryk.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.UserHistory;
import ua.com.dudaryk.repository.interfaces.UserHistoryDAO;
import ua.com.dudaryk.service.interfaces.UserHistoryService;

import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class UserHistoryServiceImpl implements UserHistoryService {


    private UserHistoryDAO userHistoryDAO;

    @Autowired
    public UserHistoryServiceImpl(UserHistoryDAO userHistoryDAO) {
        this.userHistoryDAO = userHistoryDAO;
    }

    public UserHistory save(UserHistory userHistory) {
        return userHistoryDAO.saveUserHistory(userHistory);
    }

    public UserHistory update(UserHistory userHistory) {
        return userHistoryDAO.updateUserHistory(userHistory);
    }

    public void delete(int id) {
        userHistoryDAO.deleteUserHistory(userHistoryDAO.findByIdUserHistory(id));
    }

    public UserHistory findById(int id) {
        return userHistoryDAO.findByIdUserHistory(id);
    }

    public List<UserHistory> findAll() {
        return userHistoryDAO.findAllUserHistory();
    }

    @Transactional(readOnly = true)
    public List<UserHistory> findByDudarykId(int id) {
        List<UserHistory> list = userHistoryDAO.findByDudarykId(id);
        list.sort(Comparator.comparing(UserHistory::getUserHistoryId));
        return list;
    }


}
