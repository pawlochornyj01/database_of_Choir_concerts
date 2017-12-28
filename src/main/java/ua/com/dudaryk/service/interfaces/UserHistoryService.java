package ua.com.dudaryk.service.interfaces;

import ua.com.dudaryk.service.dto.UserHistoryDTO;

import java.util.List;

public interface UserHistoryService {

    List<UserHistoryDTO> findByDudarykId(Long id);
}
