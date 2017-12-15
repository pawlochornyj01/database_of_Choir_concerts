package ua.com.dudaryk.repository.interfaces;


import ua.com.dudaryk.model.Concert;

import java.time.LocalDateTime;
import java.util.List;

public interface ConcertDAO {

    List<Concert> findByName(String name);

    List<Concert> findByDate(LocalDateTime date);

    List<Concert> findByParticipant(Long id);

}
