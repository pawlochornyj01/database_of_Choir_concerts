package ua.com.dudaryk.service.interfaces;

import ua.com.dudaryk.model.Concert;
import ua.com.dudaryk.model.Dudaryk;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface ConcertService {

    List<Concert> findByName(String name);

    List<Concert> findByDate(LocalDateTime date);

    List<Concert> findByParticipant(int id);

    Concert save(Concert concert);

    Concert update(Concert concert);

    void delete(int id);

    Concert findById(int id);

    List<Concert> findAll();

    List<Concert> findByDudarykId(int id);

    List<Concert> findByDudaryk(Dudaryk dudaryk);

    List<Concert> filterByCommunicationCondition(int id);
}
