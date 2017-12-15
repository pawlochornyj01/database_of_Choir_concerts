package ua.com.dudaryk.repository;

import java.util.List;

public interface ParticipantDAO<Participant> {

    List<Participant> findByName(String name);

//    List<Participant> findByConcert(Long id);
}
