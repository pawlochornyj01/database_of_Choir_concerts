package ua.com.dudaryk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.com.dudaryk.model.Concert;
import ua.com.dudaryk.model.Participant;
import ua.com.dudaryk.service.interfaces.ConcertService;
import ua.com.dudaryk.service.interfaces.ParticipantService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

//
//    @RequestMapping(value = "update/", method = RequestMethod.POST)
//    public Concert update(@RequestBody Concert concert) {
//
//        if (concert.getConcertId() > 0)
//            concert = concertService.update(concert);
//        return concert;
//    }
//
//    @RequestMapping(value = "save/", method = RequestMethod.POST)
//    public Concert save(@RequestBody Concert concert) {
//
//        return concertService.save(concert);
//    }
//
//    @GetMapping(value = "delete/")
//    public void delete(@PathVariable("id") int id) {
//        concertService.delete(id);
//    }
//
//    @GetMapping(value = "byId/")
//    public Concert findById(@PathVariable("id") int id) {
//        return concertService.findById(id);
//    }
//
//    @GetMapping(value = "byParticipantId/")
//    public List<Concert> findByParticipant(@PathVariable("id") int id) {
//        return concertService.findByParticipant(id);
//    }
//
//    @GetMapping(value = "byDate/")
//    public List<Concert> findByDate(@PathVariable("date") LocalDateTime date) {
//        return concertService.findByDate(date);
//    }
//
//    @GetMapping(value = "byName/")
//    public List<Concert> findByName(@PathVariable("name") String name) {
//        return concertService.findByName(name);
//    }
//
////    @RequestMapping(value = "concert/",method = RequestMethod.GET)
////    public  String displayConcertPage(Model model){
////        Concert concert = new Concert();
////
////        model.addAttribute("concert",concert);
////        return "concert";
////    }
////
////    @RequestMapping(value="concert/", method = RequestMethod.POST)
////    public String processConcert(@ModelAttribute("concert") Concert concert) {
////        System.out.println(concert);
////
////        return "redirect:index.html";
////    }


}
