package ua.com.dudaryk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.com.dudaryk.model.Communication;
import ua.com.dudaryk.model.Dudaryk;
import ua.com.dudaryk.model.Voice;
import ua.com.dudaryk.service.interfaces.DudarykService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("singer/")
public class DudarykController {

    private DudarykService dudarykService;

    @Autowired
    public DudarykController(DudarykService dudarykService) {
        this.dudarykService = dudarykService;
    }

@GetMapping(value = "all/")
public ModelAndView findAll() {
    ModelAndView modelAndView = new ModelAndView("dudaryk/all");
    modelAndView.addObject("dudarykList", dudarykService.findAll());
    return modelAndView;
}
    @RequestMapping(value = "add/", method = RequestMethod.POST)
    public String addDudaryk(@ModelAttribute("communication") @Valid Dudaryk dudaryk, BindingResult
    result) {
        if (result.hasErrors()) {
            return "singer/all/";
        }
        dudarykService.save(dudaryk);
        return "redirect:singer/all/";
    }

    @RequestMapping(value = "delete/{id}/", method = RequestMethod.GET)
    public String deleteDudaryk(@PathVariable int id) {
        dudarykService.delete(new Dudaryk().setDudarykId(id));
        return "redirect:/singer/all/";
    }
    @RequestMapping(value = "update/{id}/", method = RequestMethod.POST)
    public String updateDudaryk(@PathVariable("id") int id, @ModelAttribute("dudaryk") Dudaryk dudaryk) {

        dudarykService.update(dudaryk.setDudarykId(id));
        return "redirect:/singer/all/";
    }

//    @GetMapping(value = "byId/{id}")
//    public ModelAndView findById(@PathVariable("id") int id) {
//        ModelAndView modelAndView = new ModelAndView("dudaryk/byId");
//        modelAndView.addObject("dudarykList", dudarykService.findById(id));
//        return modelAndView;
//    }
    //    @GetMapping(value = "byId/")
//    public Dudaryk findById(@PathVariable("id") Long id) {
//        return dudarykService.findById(id);
//    }

    @GetMapping(value = "byName/")
    public ModelAndView findByName(@RequestParam("name") String name) {
        ModelAndView modelAndView = new ModelAndView("dudaryk/searchList");
        modelAndView.addObject("dudarykList", dudarykService.findByName(name));
        return modelAndView;
    }

    @GetMapping(value = "byLastName/")
    public ModelAndView byLastName(@RequestParam("lastName") String lastName) {
        ModelAndView modelAndView = new ModelAndView("dudaryk/searchList");
        modelAndView.addObject("dudarykList", dudarykService.findByLastName(lastName));
        return modelAndView;
    }

    @GetMapping(value = "byVoice/")
    public ModelAndView findByVoice(@RequestParam("voice") Voice voice) {
        ModelAndView modelAndView = new ModelAndView("dudaryk/searchList");
        modelAndView.addObject("dudarykList", dudarykService.findByVoice(voice));
        return modelAndView;
    }

    @GetMapping(value = "action/")
    public ModelAndView findAction() {
        ModelAndView modelAndView = new ModelAndView("dudaryk/searchList");
        modelAndView.addObject("dudarykList", dudarykService.findAction());
        return modelAndView;
    }

//    @GetMapping(value = "byConcert/")
//    public ModelAndView findByConcert(@PathVariable("id") int id) {
//        ModelAndView modelAndView = new ModelAndView("dudaryk/searchList");
//        modelAndView.addObject("dudarykList", dudarykService.findByConcert(id));
//        return modelAndView;
//    }




}
