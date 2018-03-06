package ua.com.dudaryk.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.Concert;
import ua.com.dudaryk.repository.interfaces.ConcertDAO;
import ua.com.dudaryk.service.interfaces.ConcertService;


import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class ConcertServiceImpl implements ConcertService {

    private ConcertDAO concertDAO;


    @Autowired
    public ConcertServiceImpl(ConcertDAO concertDAO) {
        this.concertDAO = concertDAO;
    }

    public Concert save(Concert concert) {
        return concertDAO.saveConcert(concert);
    }

    public Concert update(Concert concert) {
        return concertDAO.updateConcert(concert);
    }

    public void delete(int id) {
        concertDAO.deleteConcert(concertDAO.findConcertById(id));
    }

    public Concert findById(int id) {
        return concertDAO.findConcertById(id);
    }

    public List<Concert> findAll() {
        List<Concert> list = concertDAO.findAllConcerts();
        list.sort(Comparator.comparing(Concert::getConcertId));
        return list;
    }

    @Override
    public List<Concert> findByDudarykId(int id) {
        List<Concert> list = concertDAO.findByDudarykId(id);
        list.sort(Comparator.comparing(Concert::getConcertId));
        return list;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Concert> findByName(String name) {
        List<Concert> list = concertDAO.findByName(name);
        list.sort(Comparator.comparing(Concert::getConcertId));
        return list;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Concert> findByDate(LocalDateTime date) {

        List<Concert> list = concertDAO.findByDate(date);
        list.sort(Comparator.comparing(Concert::getConcertId));
        return list;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Concert> findByParticipant(int id) {

        List<Concert> list = concertDAO.findByParticipant(id);
        list.sort(Comparator.comparing(Concert::getConcertId));
        return list;
    }
}
