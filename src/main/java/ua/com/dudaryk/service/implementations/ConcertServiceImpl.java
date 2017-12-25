package ua.com.dudaryk.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.Concert;
import ua.com.dudaryk.repository.interfaces.ConcertDAO;
import ua.com.dudaryk.service.interfaces.ConcertService;
import ua.com.dudaryk.service.transfers.ConcertDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ConcertServiceImpl implements ConcertService {

    private ConcertDAO concertDAO;


    @Autowired
    public ConcertServiceImpl(ConcertDAO concertDAO) {
        this.concertDAO = concertDAO;
    }

    private List<ConcertDTO> DTOListBuilder(List<Concert> concerts, List<ConcertDTO> concertDTOList) {
        for (Concert concert : concerts) {
            ConcertDTO concertDTO = new ConcertDTO()
                    .setConcertId(concert.getConcertId())
                    .setCommunications(concert.getCommunications())
                    .setDate(concert.getDate())
                    .setDudaryks(concert.getDudaryks())
                    .setGenre(concert.getGenre())
                    .setName(concert.getName())
                    .setParticipants(concert.getParticipants())
                    .setPoster(concert.getPoster());
            concertDTOList.add(concertDTO);
        }

        return concertDTOList;
    }

    public ConcertDTO save(ConcertDTO concertDTO) {
        Concert concert = new Concert()
                .setCommunications(concertDTO.getCommunications())
                .setDate(concertDTO.getDate())
                .setDudaryks(concertDTO.getDudaryks())
                .setGenre(concertDTO.getGenre())
                .setName(concertDTO.getName())
                .setParticipants(concertDTO.getParticipants())
                .setPoster(concertDTO.getPoster());
        concert = concertDAO.saveConcert(concert);
        return concertDTO;
    }

    public ConcertDTO update(ConcertDTO concertDTO) {
        Concert concert = new Concert()
                .setCommunications(concertDTO.getCommunications())
                .setDate(concertDTO.getDate())
                .setDudaryks(concertDTO.getDudaryks())
                .setGenre(concertDTO.getGenre())
                .setName(concertDTO.getName())
                .setParticipants(concertDTO.getParticipants())
                .setPoster(concertDTO.getPoster());
        concert = concertDAO.updateConcert(concert);
        concertDTO.setConcertId(concert.getConcertId());
        return concertDTO;
    }

    public void delete(Long id) {
        Concert concert = concertDAO.findConcertById(id);
        concertDAO.deleteConcert(concert);
    }

    public ConcertDTO findById(Long id) {
        Concert concert = concertDAO.findConcertById(id);
        return new ConcertDTO()
                .setConcertId(concert.getConcertId())
                .setCommunications(concert.getCommunications())
                .setDate(concert.getDate())
                .setDudaryks(concert.getDudaryks())
                .setGenre(concert.getGenre())
                .setName(concert.getName())
                .setParticipants(concert.getParticipants())
                .setPoster(concert.getPoster());

    }

    public List<ConcertDTO> findAll() {
        List<Concert> concerts = concertDAO.findAllConcerts();
        List<ConcertDTO> concertDTOList = new ArrayList<>();
        return DTOListBuilder(concerts, concertDTOList);
    }

    @Override
    public List<ConcertDTO> findByName(String name) {
        List<Concert> concerts = concertDAO.findByName(name);
        List<ConcertDTO> concertDTOList = new ArrayList<>();
        return DTOListBuilder(concerts, concertDTOList);
    }

    @Override
    public List<ConcertDTO> findByDate(LocalDateTime date) {
        List<Concert> concerts = concertDAO.findByDate(date);
        List<ConcertDTO> concertDTOList = new ArrayList<>();
        return DTOListBuilder(concerts, concertDTOList);

    }

    @Override
    public List<ConcertDTO> findByParticipant(Long id) {
        List<Concert> concerts = concertDAO.findByParticipant(id);
        List<ConcertDTO> concertDTOList = new ArrayList<>();
        return DTOListBuilder(concerts, concertDTOList);
    }
}
