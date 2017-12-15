package ua.com.dudaryk.repository.interfaces;

import java.util.List;

public interface UserHistoryDAO<T> {

    List<T> findByDudarykId(Long id);
}
