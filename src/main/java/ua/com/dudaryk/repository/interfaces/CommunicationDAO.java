package ua.com.dudaryk.repository.interfaces;

import ua.com.dudaryk.model.Communication;

import java.time.LocalDateTime;
import java.util.List;

public interface CommunicationDAO {

    List<Communication> findByConcertId(Long id);

    List<Communication> findByMembershipDate(LocalDateTime date);

    List<Communication> findByName(String name);
}
