package ua.com.dudaryk.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.Communication;
import ua.com.dudaryk.model.Concert;
import ua.com.dudaryk.model.Dudaryk;
import ua.com.dudaryk.repository.interfaces.CommunicationDAO;
import ua.com.dudaryk.repository.interfaces.ConcertDAO;
import ua.com.dudaryk.service.interfaces.ConcertService;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class ConcertServiceImpl implements ConcertService {

    private ConcertDAO concertDAO;
    private CommunicationDAO communicationDAO;


    @Autowired
    public ConcertServiceImpl(ConcertDAO concertDAO, CommunicationDAO communicationDAO) {
        this.concertDAO = concertDAO;
        this.communicationDAO = communicationDAO;
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

    @Override
    public List<Concert> findByDudaryk(Dudaryk dudaryk) {
        return findByDudarykId(dudaryk.getDudarykId());
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

    @Transactional(readOnly = true)
    @Override
    public List<Concert> filterByCommunicationCondition(int id){
        List<Concert> concertList = concertDAO.findByDudarykId(id);
        return concertList.stream()
                .filter(concert ->
                        concert.getCommunications()
                                .stream()
                                .anyMatch(communication -> communication.getPhone() != null)
                )
                .collect(Collectors.toList());
    }
}
