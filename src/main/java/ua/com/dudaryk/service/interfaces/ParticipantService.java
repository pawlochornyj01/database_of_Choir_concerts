package ua.com.dudaryk.service.interfaces;

import ua.com.dudaryk.model.Concert;
import ua.com.dudaryk.model.Participant;
import ua.com.dudaryk.service.dto.ParticipantDTO;

import java.util.List;

public interface ParticipantService {

    List<Participant> findByName(String name);

    Participant save(Participant participant);

    void delete(int id);

    Participant findById(int id);

    List<Participant> findByConcertId(int id);

    List<Participant> findByConcertList(List<Concert> concertList);
}
