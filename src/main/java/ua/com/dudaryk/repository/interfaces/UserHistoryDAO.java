package ua.com.dudaryk.repository.interfaces;

import ua.com.dudaryk.model.UserHistory;

import java.util.List;

public interface UserHistoryDAO {

    List<UserHistory> findByDudarykId(Long id);
}
