package ua.com.dudaryk.service.interfaces;

import ua.com.dudaryk.model.Voice;
import ua.com.dudaryk.service.transfers.DudarykDTO;

import java.util.List;

public interface DudarykService {

    List<DudarykDTO> findByName(String name);

    List<DudarykDTO> findByLastName(String lastName);

    List<DudarykDTO> findByVoice(Voice voice);

    List<DudarykDTO> findAction();

    List<DudarykDTO> findByConcert(Long id);
}
