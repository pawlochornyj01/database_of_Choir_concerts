package ua.com.dudaryk.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.Dudaryk;
import ua.com.dudaryk.model.Voice;
import ua.com.dudaryk.repository.interfaces.DudarykDAO;
import ua.com.dudaryk.service.interfaces.DudarykService;
import ua.com.dudaryk.service.transfers.DudarykDTO;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DudarykServiceImpl implements DudarykService {

    private DudarykDAO dudarykDAO;

    @Autowired
    public DudarykServiceImpl(DudarykDAO dudarykDAO) {
        this.dudarykDAO = dudarykDAO;
    }


    private List<DudarykDTO> DTOListBuilder(List<Dudaryk> dudaryks, List<DudarykDTO> dudarykDTOList) {
        for (Dudaryk dudaryk : dudaryks) {
            DudarykDTO dudarykDTO = new DudarykDTO()
                    .setDudarykId(dudaryk.getDudarykId())
                    .setAction(dudaryk.isAction())
                    .setCategories(dudaryk.getCategories())
                    .setConcerts(dudaryk.getConcerts())
                    .setDateOfBirthday(dudaryk.getDateOfBirthday())
                    .setDescription(dudaryk.getDescription())
                    .setEmail(dudaryk.getEmail())
                    .setLastName(dudaryk.getLastName())
                    .setName(dudaryk.getName())
                    .setPhone(dudaryk.getPhone())
                    .setPhoto(dudaryk.getPhoto())
                    .setUserHistories(dudaryk.getUserHistories())
                    .setVoice(dudaryk.getVoice());
            dudarykDTOList.add(dudarykDTO);
        }

        return dudarykDTOList;
    }

    public DudarykDTO save(DudarykDTO dudarykDTO) {
        Dudaryk dudaryk = new Dudaryk()
                .setAction(dudarykDTO.isAction())
                .setCategories(dudarykDTO.getCategories())
                .setConcerts(dudarykDTO.getConcerts())
                .setDateOfBirthday(dudarykDTO.getDateOfBirthday())
                .setDescription(dudarykDTO.getDescription())
                .setEmail(dudarykDTO.getEmail())
                .setLastName(dudarykDTO.getLastName())
                .setName(dudarykDTO.getName())
                .setPhone(dudarykDTO.getPhone())
                .setPhoto(dudarykDTO.getPhoto())
                .setUserHistories(dudarykDTO.getUserHistories())
                .setVoice(dudarykDTO.getVoice());
        dudaryk = dudarykDAO.saveDudaryk(dudaryk);
        return dudarykDTO;
    }

    public DudarykDTO update(DudarykDTO dudarykDTO) {
        Dudaryk dudaryk = new Dudaryk()
                .setAction(dudarykDTO.isAction())
                .setCategories(dudarykDTO.getCategories())
                .setConcerts(dudarykDTO.getConcerts())
                .setDateOfBirthday(dudarykDTO.getDateOfBirthday())
                .setDescription(dudarykDTO.getDescription())
                .setEmail(dudarykDTO.getEmail())
                .setLastName(dudarykDTO.getLastName())
                .setName(dudarykDTO.getName())
                .setPhone(dudarykDTO.getPhone())
                .setPhoto(dudarykDTO.getPhoto())
                .setUserHistories(dudarykDTO.getUserHistories())
                .setVoice(dudarykDTO.getVoice());
        dudaryk = dudarykDAO.updateDudaryk(dudaryk);
        dudarykDTO.setDudarykId(dudaryk.getDudarykId());
        return dudarykDTO;
    }

    public void delete(Long id) {
        Dudaryk dudaryk = dudarykDAO.findDudarykById(id);
        dudarykDAO.deleteDudaryk(dudaryk);
    }

    public DudarykDTO findById(Long id) {
        Dudaryk dudaryk = dudarykDAO.findDudarykById(id);
        return new DudarykDTO()
                .setDudarykId(dudaryk.getDudarykId())
                .setAction(dudaryk.isAction())
                .setCategories(dudaryk.getCategories())
                .setConcerts(dudaryk.getConcerts())
                .setDateOfBirthday(dudaryk.getDateOfBirthday())
                .setDescription(dudaryk.getDescription())
                .setEmail(dudaryk.getEmail())
                .setLastName(dudaryk.getLastName())
                .setName(dudaryk.getName())
                .setPhone(dudaryk.getPhone())
                .setPhoto(dudaryk.getPhoto())
                .setUserHistories(dudaryk.getUserHistories())
                .setVoice(dudaryk.getVoice());
    }

    public List<DudarykDTO> findAll() {
        List<Dudaryk> dudaryks = dudarykDAO.findAllDudaryks();
        List<DudarykDTO> dudarykDTOList = new ArrayList<>();
        return DTOListBuilder(dudaryks, dudarykDTOList);
    }

    @Override
    public List<DudarykDTO> findByName(String name) {
        List<Dudaryk> dudaryks = dudarykDAO.findByName(name);
        List<DudarykDTO> dudarykDTOList = new ArrayList<>();
        return DTOListBuilder(dudaryks, dudarykDTOList);
    }

    @Override
    public List<DudarykDTO> findByLastName(String lastName) {
        List<Dudaryk> dudaryks = dudarykDAO.findByLastName(lastName);
        List<DudarykDTO> dudarykDTOList = new ArrayList<>();
        return DTOListBuilder(dudaryks, dudarykDTOList);
    }

    @Override
    public List<DudarykDTO> findByVoice(Voice voice) {
        List<Dudaryk> dudaryks = dudarykDAO.findByVoice(voice);
        List<DudarykDTO> dudarykDTOList = new ArrayList<>();
        return DTOListBuilder(dudaryks, dudarykDTOList);
    }

    @Override
    public List<DudarykDTO> findAction() {
        List<Dudaryk> dudaryks = dudarykDAO.findAction();
        List<DudarykDTO> dudarykDTOList = new ArrayList<>();
        return DTOListBuilder(dudaryks, dudarykDTOList);
    }

    @Override
    public List<DudarykDTO> findByConcert(Long id) {
        List<Dudaryk> dudaryks = dudarykDAO.findByConcert(id);
        List<DudarykDTO> dudarykDTOList = new ArrayList<>();
        return DTOListBuilder(dudaryks, dudarykDTOList);
    }
}
