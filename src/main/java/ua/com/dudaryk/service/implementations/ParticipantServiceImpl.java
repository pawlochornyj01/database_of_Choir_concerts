package ua.com.dudaryk.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.Concert;
import ua.com.dudaryk.model.Participant;
import ua.com.dudaryk.repository.interfaces.ParticipantDAO;
import ua.com.dudaryk.service.interfaces.ParticipantService;
import ua.com.dudaryk.service.dto.ParticipantDTO;


import java.util.*;

@Service
@Transactional
public class ParticipantServiceImpl implements ParticipantService {

    private ParticipantDAO participantDAO;

    @Autowired
    public ParticipantServiceImpl(ParticipantDAO participantDAO) {
        this.participantDAO = participantDAO;
    }


    public Participant save(Participant participant) {
        return participantDAO.saveParticipant(participant);
    }

    public void delete(int id) {
        participantDAO.deleteParticipant(participantDAO.findParticipantById(id));
    }

    public Participant findById(int id) {
        return participantDAO.findParticipantById(id);
    }

    @Override
    public List<Participant> findByConcertId(int id) {
        List<Participant> list = participantDAO.findByConcertId(id);
        list.sort(Comparator.comparing(Participant::getParticipantId));
        return list;
    }
    @Override
    public List<Participant> findByConcertList(List<Concert> concertList) {

        Set<Participant> participantSet = new TreeSet<>();
        for (Concert concert : concertList) {
            participantSet.addAll(findByConcertId(concert.getConcertId()));

        }
        List<Participant> list = new ArrayList<>(participantSet);
        list.sort(Comparator.comparing(Participant::getParticipantId));
        return list;
    }


    @Transactional(readOnly = true)
    @Override
    public List<Participant> findByName(String name) {

        List<Participant> list = participantDAO.findByName(name);
        list.sort(Comparator.comparing(Participant::getParticipantId));
        return list;

    }
}
