package ua.com.dudaryk.repository.interfaces;

import ua.com.dudaryk.model.UserHistory;

import java.util.List;

public interface UserHistoryDAO  {

    List<UserHistory> findByDudarykId(int id);

    List<UserHistory> findAllUserHistory();

    UserHistory saveUserHistory(UserHistory userHistory);

    UserHistory updateUserHistory(UserHistory userHistory);

    UserHistory findByIdUserHistory(int id);

    void deleteUserHistory(UserHistory userHistory);

}
