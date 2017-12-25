package ua.com.dudaryk.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.Participant;
import ua.com.dudaryk.repository.interfaces.ParticipantDAO;
import ua.com.dudaryk.service.interfaces.ParticipantService;
import ua.com.dudaryk.service.transfers.ParticipantDTO;


import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ParticipantServiceImpl implements ParticipantService {

    private ParticipantDAO participantDAO;

    @Autowired
    public ParticipantServiceImpl(ParticipantDAO participantDAO) {
        this.participantDAO = participantDAO;
    }

    private List<ParticipantDTO> DTOListBuilder(List<Participant> participants, List<ParticipantDTO> participantDTOList) {
        for (Participant participant : participants) {
            ParticipantDTO participantDTO = new ParticipantDTO()
                    .setParticipantId(participant.getParticipantId())
                    .setComment(participant.getComment())
                    .setConcerts(participant.getConcerts())
                    .setDescription(participant.getDescription())
                    .setEmail(participant.getEmail())
                    .setName(participant.getName())
                    .setPhone(participant.getPhone());
            participantDTOList.add(participantDTO);
        }

        return participantDTOList;
    }

    public ParticipantDTO save(ParticipantDTO participantDTO) {
        Participant participant = new Participant()
                .setComment(participantDTO.getComment())
                .setConcerts(participantDTO.getConcerts())
                .setDescription(participantDTO.getDescription())
                .setEmail(participantDTO.getEmail())
                .setName(participantDTO.getName())
                .setPhone(participantDTO.getPhone());
        participant = participantDAO.saveParticipant(participant);
        return participantDTO;
    }

    public void delete(Long id) {
        Participant participant = participantDAO.findParticipantById(id);
        participantDAO.deleteParticipant(participant);
    }

    public ParticipantDTO findById(Long id) {
        Participant participant = participantDAO.findParticipantById(id);
        return new ParticipantDTO()
                .setParticipantId(participant.getParticipantId())
                .setComment(participant.getComment())
                .setConcerts(participant.getConcerts())
                .setDescription(participant.getDescription())
                .setEmail(participant.getEmail())
                .setName(participant.getName())
                .setPhone(participant.getPhone());
    }

    @Override
    public List<ParticipantDTO> findByName(String name) {
        List<Participant> participants = participantDAO.findByName(name);
        List<ParticipantDTO> participantDTOList = new ArrayList<>();
        return DTOListBuilder(participants, participantDTOList);
    }
}
