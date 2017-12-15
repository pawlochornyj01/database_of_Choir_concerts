package ua.com.dudaryk.repository;

import java.time.LocalDateTime;
import java.util.List;

public interface CommunicationDAO<Communication> {

    List<Communication> findByConcertId(Long id);

    List<Communication> findByMembershipDate(LocalDateTime date);

    List<Communication> findByName(String name);
}
