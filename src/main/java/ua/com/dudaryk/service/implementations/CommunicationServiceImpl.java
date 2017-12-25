package ua.com.dudaryk.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.Communication;


import ua.com.dudaryk.repository.interfaces.CommunicationDAO;
import ua.com.dudaryk.service.interfaces.CommunicationService;
import ua.com.dudaryk.service.transfers.CommunicationDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CommunicationServiceImpl implements CommunicationService {

    private CommunicationDAO communicationDAO;

    @Autowired
    public CommunicationServiceImpl(CommunicationDAO communicationDAO) {

        this.communicationDAO = communicationDAO;
    }

    private List<CommunicationDTO> DTOListBuilder(List<Communication> communications, List<CommunicationDTO> communicationDTOList) {
        for (Communication communication : communications) {
            CommunicationDTO communicationDTO = new CommunicationDTO()
                    .setCommunicationId(communication.getCommunicationId())
                    .setName(communication.getName())
                    .setEmail(communication.getEmail())
                    .setDescription(communication.getDescription())
                    .setComment(communication.getComment())
                    .setMembershipDate(communication.getMembershipDate())
                    .setPhone(communication.getPhone())
                    .setConcert(communication.getConcert());
            communicationDTOList.add(communicationDTO);
        }
        return communicationDTOList;
    }

    public CommunicationDTO findById(Long id) {
        Communication communication = communicationDAO.findByCommunicationId(id);
        return new CommunicationDTO()
                .setCommunicationId(communication.getCommunicationId())
                .setName(communication.getName())
                .setEmail(communication.getEmail())
                .setDescription(communication.getDescription())
                .setComment(communication.getComment())
                .setMembershipDate(communication.getMembershipDate())
                .setPhone(communication.getPhone())
                .setConcert(communication.getConcert());

    }

    public CommunicationDTO save(CommunicationDTO communicationDTO) {
        Communication communication = new Communication()
                .setName(communicationDTO.getName())
                .setEmail(communicationDTO.getEmail())
                .setDescription(communicationDTO.getDescription())
                .setComment(communicationDTO.getComment())
                .setMembershipDate(communicationDTO.getMembershipDate())
                .setPhone(communicationDTO.getPhone())
                .setConcert(communicationDTO.getConcert());
        communication = communicationDAO.saveCommunication(communication);
//        communicationDTO.setCommunicationId(communication.getCommunicationId());
        return communicationDTO;
    }

    public CommunicationDTO update(CommunicationDTO communicationDTO) {
        Communication communication = new Communication()
                .setName(communicationDTO.getName())
                .setEmail(communicationDTO.getEmail())
                .setDescription(communicationDTO.getDescription())
                .setComment(communicationDTO.getComment())
                .setMembershipDate(communicationDTO.getMembershipDate())
                .setPhone(communicationDTO.getPhone())
                .setConcert(communicationDTO.getConcert());
        communication = communicationDAO.updateCommunication(communication);
        communicationDTO.setCommunicationId(communication.getCommunicationId());
        return communicationDTO;
    }

    public void delete(Long id) {
        Communication communication = communicationDAO.findByCommunicationId(id);
        communicationDAO.deleteCommunication(communication);

    }

    public List<CommunicationDTO> findAll() {
        List<Communication> communications = communicationDAO.findAllCommunication();
        List<CommunicationDTO> communicationDTOList = new ArrayList<>();
        return DTOListBuilder(communications, communicationDTOList);
    }

    @Override
    public List<CommunicationDTO> findByConcertId(Long id) {
        List<Communication> communications = communicationDAO.findByConcertId(id);
        List<CommunicationDTO> communicationDTOList = new ArrayList<>();
        return DTOListBuilder(communications, communicationDTOList);
    }

    @Override
    public List<CommunicationDTO> findByMembershipDate(LocalDateTime date) {
        List<Communication> communications = communicationDAO.findByMembershipDate(date);
        List<CommunicationDTO> communicationDTOList = new ArrayList<>();
        return DTOListBuilder(communications, communicationDTOList);
    }

    @Override
    public List<CommunicationDTO> findByName(String name) {
        List<Communication> communications = communicationDAO.findByName(name);
        List<CommunicationDTO> communicationDTOList = new ArrayList<>();
        return DTOListBuilder(communications, communicationDTOList);
    }
}
