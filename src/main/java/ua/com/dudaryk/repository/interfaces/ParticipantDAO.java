package ua.com.dudaryk.repository.interfaces;

import java.util.List;

public interface ParticipantDAO<T> {

    List<T> findByName(String name);

//    List<T> findByConcert(Long id);
}
