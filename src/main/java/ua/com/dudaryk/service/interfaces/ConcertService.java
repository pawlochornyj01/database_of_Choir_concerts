package ua.com.dudaryk.service.interfaces;

import ua.com.dudaryk.service.transfers.ConcertDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface ConcertService {

    List<ConcertDTO> findByName(String name);

    List<ConcertDTO> findByDate(LocalDateTime date);

    List<ConcertDTO> findByParticipant(Long id);
}
