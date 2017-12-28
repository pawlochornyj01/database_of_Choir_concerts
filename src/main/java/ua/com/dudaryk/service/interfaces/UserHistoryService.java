package ua.com.dudaryk.service.interfaces;

import ua.com.dudaryk.model.UserHistory;
import ua.com.dudaryk.service.dto.UserHistoryDTO;

import java.util.List;

public interface UserHistoryService {

    List<UserHistory> findByDudarykId(Long id);
}
