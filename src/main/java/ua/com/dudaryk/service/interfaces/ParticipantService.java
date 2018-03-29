package ua.com.dudaryk.service.interfaces;

import ua.com.dudaryk.model.Concert;
import ua.com.dudaryk.model.Participant;

import java.util.List;
import java.util.Set;

public interface ParticipantService {

    List<Participant> findByName(String name);

    Participant save(Participant participant);

    List<Participant> findAll();

    void delete(int id);

    Participant findById(int id);

    List<Participant> findByConcertId(int id);

    List<Participant> findByConcertList(List<Concert> concertList);


    List<String> findByConcertWithEmailCondition(List<Concert> concertSet);

}
