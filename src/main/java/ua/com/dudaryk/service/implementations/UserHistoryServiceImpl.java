package ua.com.dudaryk.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.UserHistory;
import ua.com.dudaryk.repository.implementations.UserHistoryDAOImpl;
import ua.com.dudaryk.service.AbstractServiceImpl;
import ua.com.dudaryk.service.interfaces.AbstractService;
import ua.com.dudaryk.service.interfaces.UserHistoryService;
import ua.com.dudaryk.service.transfers.UserHistoryDTO;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserHistoryServiceImpl extends AbstractServiceImpl<UserHistoryDTO> implements UserHistoryService, AbstractService<UserHistoryDTO> {

    @Autowired
    private UserHistoryDAOImpl userHistoryDAO;

    @Override
    public void setClazz(Class<UserHistoryDTO> clazzToSet) {
        super.setClazz(clazzToSet);
    }

    private List<UserHistoryDTO> DTOListBuilder(List<UserHistory> userHistories,List<UserHistoryDTO> userHistoryDTOList ){
        for (UserHistory userHistory : userHistories) {
            UserHistoryDTO userHistoryDTO = new UserHistoryDTO();
            userHistoryDTO.setUserHistoryId(userHistory.getUserHistoryId());
            userHistoryDTO.setAction(userHistory.getAction());
            userHistoryDTO.setComment(userHistory.getComment());
            userHistoryDTO.setDate(userHistory.getDate());
            userHistoryDTO.setDescription(userHistory.getDescription());
            userHistoryDTO.setDudaryk(userHistory.getDudaryk());
            userHistoryDTOList.add(userHistoryDTO);
        }
        return userHistoryDTOList;
    }


    @Override
    public UserHistoryDTO save(UserHistoryDTO userHistoryDTO) {
        UserHistory userHistory = new UserHistory();
        userHistory.setDudaryk(userHistoryDTO.getDudaryk());
        userHistory.setDate(userHistoryDTO.getDate());
        userHistory.setComment(userHistoryDTO.getComment());
        userHistory.setDescription(userHistoryDTO.getDescription());
        userHistory.setAction(userHistoryDTO.getAction());
        userHistory = userHistoryDAO.save(userHistory);
        userHistoryDTO.setUserHistoryId(userHistory.getUserHistoryId());
        return userHistoryDTO;
    }

    @Override
    public UserHistoryDTO update(UserHistoryDTO userHistoryDTO) {
        UserHistory userHistory = new UserHistory();
        userHistory.setDudaryk(userHistoryDTO.getDudaryk());
        userHistory.setDate(userHistoryDTO.getDate());
        userHistory.setComment(userHistoryDTO.getComment());
        userHistory.setDescription(userHistoryDTO.getDescription());
        userHistory.setAction(userHistoryDTO.getAction());
        userHistory = userHistoryDAO.update(userHistory);
        userHistoryDTO.setUserHistoryId(userHistory.getUserHistoryId());
        return userHistoryDTO;
    }

    @Override
    public void delete(Long id) {
        UserHistory userHistory = userHistoryDAO.findById(id);
        userHistoryDAO.delete(userHistory);
    }

    @Override
    public UserHistoryDTO findById(Long id) {
        UserHistory userHistory = userHistoryDAO.findById(id);
        UserHistoryDTO userHistoryDTO = new UserHistoryDTO();
        userHistoryDTO.setUserHistoryId(userHistory.getUserHistoryId());
        userHistoryDTO.setAction(userHistory.getAction());
        userHistoryDTO.setComment(userHistory.getComment());
        userHistoryDTO.setDate(userHistory.getDate());
        userHistoryDTO.setDescription(userHistory.getDescription());
        userHistoryDTO.setDudaryk(userHistory.getDudaryk());
        return userHistoryDTO;
    }

    @Override
    public List<UserHistoryDTO> findAll() {

        List<UserHistory> userHistories = userHistoryDAO.findAll();
        List<UserHistoryDTO> userHistoryDTOList = new ArrayList<>();

        return DTOListBuilder(userHistories,userHistoryDTOList);

    }

    public List<UserHistoryDTO> findByDudarykId(Long id) {
        List<UserHistory> userHistories = userHistoryDAO.findByDudarykId(id);
        List<UserHistoryDTO> userHistoryDTOList = new ArrayList<>();

        return DTOListBuilder(userHistories,userHistoryDTOList);
    }


}
