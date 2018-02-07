package ua.com.dudaryk.service.interfaces;

import ua.com.dudaryk.model.Concert;
import ua.com.dudaryk.service.dto.ConcertDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface ConcertService {

    List<Concert> findByName(String name);

    List<Concert> findByDate(LocalDateTime date);

    List<Concert> findByParticipant(int id);

    Concert save(Concert concert);

    Concert update(Concert concert);

    void delete(int id);

    Concert findById(int id);

    List<Concert> findAll();
}
