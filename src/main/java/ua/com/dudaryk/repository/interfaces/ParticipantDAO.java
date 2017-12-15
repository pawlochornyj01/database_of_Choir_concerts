package ua.com.dudaryk.repository.interfaces;

import ua.com.dudaryk.model.Participant;

import java.util.List;

public interface ParticipantDAO {

    List<Participant> findByName(String name);

//    List<T> findByConcert(Long id);
}
