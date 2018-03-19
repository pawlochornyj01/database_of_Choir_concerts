package ua.com.dudaryk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.com.dudaryk.model.Dudaryk;
import ua.com.dudaryk.model.Participant;
import ua.com.dudaryk.service.interfaces.ConcertService;
import ua.com.dudaryk.service.interfaces.DudarykService;
import ua.com.dudaryk.service.interfaces.ParticipantService;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("concert/")
public class ConcertController {

    private ConcertService concertService;
    private ParticipantService participantService;
    private DudarykService dudarykService;

    @Autowired
    public ConcertController(ConcertService concertService, ParticipantService participantService) {
        this.concertService = concertService;
        this.participantService = participantService;
    }

    @GetMapping(value = "all/")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("concert/all");
        modelAndView.addObject("concertList", concertService.findAll());
        return modelAndView;
    }

    @GetMapping(value = "participants/{id}")
    public ModelAndView showMutualParticipants(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("concert/mutual_participants");
        modelAndView.addObject("participantList",
                participantService.findByConcertList(concertService.findByDudarykId(id)));
        return modelAndView;
    }
    @ResponseBody
    @GetMapping(value = "get-participants/{dudarykId}")
    public ResponseEntity<List<Participant>> getMutualParticipants(@PathVariable int dudarykId) {
        List<Participant> participantsByDudaryk =
                participantService.findByConcertList(concertService.findByDudarykId(dudarykId));
        return new ResponseEntity<>(participantsByDudaryk, HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(value = "get-names-participants/{dudarykId}")
    public ResponseEntity<List<String>> getNamesParticipantsByDudaryk(@PathVariable int dudarykId) {
        List<String> participantsByDudaryk =
                participantService.findByConcertSetWithEmailCondition(
                        concertService.findWithCommunicationAndDateOfConcertConditionByDudaryk(dudarykService.findById(dudarykId)));
        return new ResponseEntity<>(participantsByDudaryk, HttpStatus.OK);
    }

}
