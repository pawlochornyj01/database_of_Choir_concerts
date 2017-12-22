package ua.com.dudaryk.service.interfaces;

import ua.com.dudaryk.service.transfers.ParticipantDTO;

import java.util.List;

public interface ParticipantService {

    List<ParticipantDTO> findByName(String name);

//    List<ParticipantDTO> findByConcert(Long id);
}