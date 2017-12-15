package ua.com.dudaryk.repository.interfaces;

import java.util.List;

public interface DudarykDAO<T> {

    List<T> findByName(String name);

    List<T> findByLastName(String lastName);

    List<T> findByVoice(String voice);

    List<T> findAction();

    List<T> findByConcert(Long id);

}
