package ua.com.dudaryk.repository.interfaces;

import java.time.LocalDateTime;
import java.util.List;

public interface CommunicationDAO<T> {

    List<T> findByConcertId(Long id);

    List<T> findByMembershipDate(LocalDateTime date);

    List<T> findByName(String name);
}
