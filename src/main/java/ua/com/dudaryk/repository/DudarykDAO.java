package ua.com.dudaryk.repository;
import ua.com.dudaryk.model.Dudaryk;
import ua.com.dudaryk.model.Voice;

import java.util.List;

public interface DudarykDAO<Dudaryk> {

    public List<Dudaryk> findByName(String name);
    public List<Dudaryk> findByLastName(String lastName);
    public List<Dudaryk> findByVoice(String voice);
    public List<Dudaryk> findAction();

}
