package ua.com.dudaryk.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.com.dudaryk.model.Communication;
import ua.com.dudaryk.service.interfaces.CommunicationService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("communication/")
public class CommunicationController {

    private CommunicationService communicationService;

    @Autowired
    public CommunicationController(CommunicationService communicationService) {
        this.communicationService = communicationService;
    }


    @GetMapping(value = "all/")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("communication/all");
        modelAndView.addObject("communicationList", communicationService.findAll());
        return modelAndView;
    }



    @RequestMapping(value = "add/", method = RequestMethod.POST)
    public String addCommunication(@ModelAttribute("communication") @Valid Communication communication, BindingResult result) {
        if (result.hasErrors()) {
            return "communication/all/";
        }
        communicationService.save(communication);
        return "redirect:communication/all/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable int id) {
        communicationService.delete(new Communication().setCommunicationId(id));
        return "redirect:/category/all/";
    }
//
//    @GetMapping(value = "delete/")
//    public void delete(@PathVariable("id") Long id) {
//        communicationService.delete(id);
//    }
//
//    @GetMapping(value = "byId/")
//    public Communication findById(@PathVariable("id") Long id) {
//        return communicationService.findById(id);
//    }
//
//    @GetMapping(value = "byConcertId/")
//    public List<Communication> findByConcertId(@PathVariable("id") Long id) {
//        return communicationService.findByConcertId(id);
//    }
//
//    @GetMapping(value = "byMembership/")
//    public List<Communication> findByMembershipDate(@PathVariable("date") LocalDateTime date) {
//        return communicationService.findByMembershipDate(date);
//    }
//
//    @GetMapping(value = "byName/")
//    public List<Communication> findByName(String name) {
//        return communicationService.findByName(name);
//    }
}
