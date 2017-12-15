package ua.com.dudaryk.repository;

import ua.com.dudaryk.model.Dudaryk;
import ua.com.dudaryk.model.Voice;

import java.util.List;

public interface DudarykDAO<Dudaryk> {

    List<Dudaryk> findByName(String name);

    List<Dudaryk> findByLastName(String lastName);

    List<Dudaryk> findByVoice(String voice);

    List<Dudaryk> findAction();

    List<Dudaryk> findByConcert(Long id);

}
