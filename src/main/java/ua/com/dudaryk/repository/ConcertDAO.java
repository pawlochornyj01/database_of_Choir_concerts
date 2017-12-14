package ua.com.dudaryk.repository;

import ua.com.dudaryk.model.Concert;

import java.time.LocalDateTime;
import java.util.List;

public interface ConcertDAO<Concert>  {

    public List<Concert> findByName(String name);
    public List<Concert> findByDATE(LocalDateTime date);

}
