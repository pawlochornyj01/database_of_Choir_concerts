package ua.com.dudaryk.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.Dudaryk;
import ua.com.dudaryk.model.Voice;
import ua.com.dudaryk.repository.interfaces.DudarykDAO;
import ua.com.dudaryk.service.interfaces.DudarykService;


import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class DudarykServiceImpl implements DudarykService {

    private DudarykDAO dudarykDAO;

    public DudarykServiceImpl(DudarykDAO dudarykDAO) {
        this.dudarykDAO = dudarykDAO;
    }

    public Dudaryk save(Dudaryk dudaryk) {
        return dudarykDAO.saveDudaryk(dudaryk);
    }

    public Dudaryk update(Dudaryk dudaryk) {
        return dudarykDAO.updateDudaryk(dudaryk);
    }

    public void delete(Dudaryk dudaryk) {
        dudarykDAO.deleteDudaryk(dudaryk);
    }

    public Dudaryk findById(int id) {
        return dudarykDAO.findDudarykById(id);
    }

    public List<Dudaryk> findAll() {

        List<Dudaryk> list = dudarykDAO.findAllDudaryks();
        list.sort(Comparator.comparing(Dudaryk::getDudarykId));
        return list;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dudaryk> findByName(String name) {

        List<Dudaryk> list = dudarykDAO.findByName(name);
        list.sort(Comparator.comparing(Dudaryk::getDudarykId));
        return list;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dudaryk> findByLastName(String lastName) {

        List<Dudaryk> list = dudarykDAO.findByLastName(lastName);
        list.sort(Comparator.comparing(Dudaryk::getDudarykId));
        return list;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dudaryk> findByVoice(Voice voice) {
        List<Dudaryk> list = dudarykDAO.findByVoice(voice);
        list.sort(Comparator.comparing(Dudaryk::getDudarykId));
        return list;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dudaryk> findAction() {
        List<Dudaryk> list = dudarykDAO.findAction();
        list.sort(Comparator.comparing(Dudaryk::getDudarykId));
        return list;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dudaryk> findByConcert(int id) {
        List<Dudaryk> list = dudarykDAO.findByConcert(id);
        list.sort(Comparator.comparing(Dudaryk::getDudarykId));
        return list;

    }
}
