package ua.com.dudaryk.repository.interfaces;


import ua.com.dudaryk.model.Concert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ConcertDAO {

    Concert saveConcert(Concert concert);

    Concert updateConcert(Concert concert);

    void deleteConcert(Concert concert);

    Concert findConcertById(int id);

    List<Concert> findAllConcerts();

    List<Concert> findByName(String name);

    List<Concert> findByDate(LocalDateTime date);

    List<Concert> findByParticipant(int id);

    List<Concert> findByDudarykId(int id);




}
