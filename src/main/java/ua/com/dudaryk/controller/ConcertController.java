package ua.com.dudaryk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.com.dudaryk.model.Dudaryk;
import ua.com.dudaryk.model.Participant;
import ua.com.dudaryk.service.interfaces.ConcertService;
import ua.com.dudaryk.service.interfaces.ParticipantService;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("concert/")
public class ConcertController {

    private ConcertService concertService;
    private ParticipantService participantService;

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

    @GetMapping(value = "get-participants/{dudarykId}")
    public ResponseEntity<List<Participant>> getMutualParticipants(@PathVariable int dudarykId) {
        List<Participant> participantsByDudaryk =
                participantService.findByConcertList(concertService.findByDudarykId(dudarykId));
        return new ResponseEntity<>(participantsByDudaryk, HttpStatus.OK);
    }

    @GetMapping(value = "get-names-participants/")
    public ResponseEntity<List<String>> getNamesParticipantsbyDudaryk(@RequestBody Dudaryk dudaryk) {
        List<String> participantsByDudaryk = participantService.findNamesOfParticipants(
                participantService.findByConcertListWithEmailCondition(
                concertService.findWithCommunicationAndDateOfConcertConditionByDudaryk(dudaryk)));
        return new ResponseEntity<>(participantsByDudaryk, HttpStatus.OK);
    }

}
