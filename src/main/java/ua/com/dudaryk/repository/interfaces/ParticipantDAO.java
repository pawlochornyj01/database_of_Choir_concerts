package ua.com.dudaryk.repository.interfaces;

import ua.com.dudaryk.model.Participant;

import java.util.List;

public interface ParticipantDAO {

    Participant saveParticipant(Participant participant);

    void deleteParticipant(Participant participant);

    Participant findParticipantById(int id);

    List<Participant> findByName(String name);

    List<Participant> findByConcertId(int id);

    List<Participant> findAllParticipant();



}
