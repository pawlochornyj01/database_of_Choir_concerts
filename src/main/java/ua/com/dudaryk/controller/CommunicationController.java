package ua.com.dudaryk.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.dudaryk.model.Communication;
import ua.com.dudaryk.service.interfaces.CommunicationService;

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
    public List<Communication> findAll() {
        return communicationService.findAll();
    }

    @RequestMapping(value = "update/", method = RequestMethod.POST)
    public Communication update(@RequestBody Communication communication) {

        if (communication.getCommunicationId() > 0)
            communication = communicationService.update(communication);
        return communication;
    }

    @RequestMapping(value = "save/", method = RequestMethod.POST)
    public Communication save(@RequestBody Communication communication) {

        return communicationService.save(communication);
    }

    @GetMapping(value = "delete/")
    public void delete(@PathVariable("id") Long id) {
        communicationService.delete(id);
    }

    @GetMapping(value = "byId/")
    public Communication findById(@PathVariable("id") Long id) {
        return communicationService.findById(id);
    }

    @GetMapping(value = "byConcertId/")
    public List<Communication> findByConcertId(@PathVariable("id") Long id) {
        return communicationService.findByConcertId(id);
    }

    @GetMapping(value = "byMembership/")
    public List<Communication> findByMembershipDate(@PathVariable("date") LocalDateTime date) {
        return communicationService.findByMembershipDate(date);
    }

    @GetMapping(value = "byName/")
    public List<Communication> findByName(String name) {
        return communicationService.findByName(name);
    }
}
