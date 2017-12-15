package ua.com.dudaryk.repository.interfaces;


import java.time.LocalDateTime;
import java.util.List;

public interface ConcertDAO<T> {

    List<T> findByName(String name);

    List<T> findByDate(LocalDateTime date);

    List<T> findByParticipant(Long id);

}
