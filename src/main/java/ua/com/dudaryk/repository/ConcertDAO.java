package ua.com.dudaryk.repository;


import java.time.LocalDateTime;
import java.util.List;

public interface ConcertDAO<Concert> {

    List<Concert> findByName(String name);

    List<Concert> findByDate(LocalDateTime date);

    List<Concert> findByParticipant(Long id);

}
