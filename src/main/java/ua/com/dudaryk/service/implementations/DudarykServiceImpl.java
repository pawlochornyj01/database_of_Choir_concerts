package ua.com.dudaryk.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.Dudaryk;
import ua.com.dudaryk.model.Voice;
import ua.com.dudaryk.repository.interfaces.DudarykDAO;
import ua.com.dudaryk.service.interfaces.DudarykService;


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

    public void delete(int id) {
        dudarykDAO.deleteDudaryk(dudarykDAO.findDudarykById(id));
    }

    public Dudaryk findById(int id) {
        return dudarykDAO.findDudarykById(id);
    }

    public List<Dudaryk> findAll() {
        return dudarykDAO.findAllDudaryks();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dudaryk> findByName(String name) {
        return dudarykDAO.findByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dudaryk> findByLastName(String lastName) {
        return dudarykDAO.findByLastName(lastName);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dudaryk> findByVoice(Voice voice) {
        return dudarykDAO.findByVoice(voice);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dudaryk> findAction() {
        return dudarykDAO.findAction();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dudaryk> findByConcert(int id) {
        return dudarykDAO.findByConcert(id);

    }
}
