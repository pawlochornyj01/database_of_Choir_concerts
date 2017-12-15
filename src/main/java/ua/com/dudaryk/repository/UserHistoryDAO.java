package ua.com.dudaryk.repository;

import java.util.List;

public interface UserHistoryDAO<UserHistory> {

    List<UserHistory> findByDudarykId(Long id);
}
