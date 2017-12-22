package ua.com.dudaryk.service.interfaces;

import ua.com.dudaryk.service.transfers.CommunicationDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface CommunicationService {

    List<CommunicationDTO> findByConcertId(Long id);

    List<CommunicationDTO> findByMembershipDate(LocalDateTime date);

    List<CommunicationDTO> findByName(String name);
}
