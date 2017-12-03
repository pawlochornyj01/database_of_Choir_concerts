package ua.com.dudaryk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.dudaryk.model.Concert;

@Controller
public class ConcertController {


    @RequestMapping(value = "/concert",method = RequestMethod.GET)
    public  String displayConcertPage(Model model){
        Concert concert = new Concert();

        model.addAttribute("concert",concert);
        return "concert";
    }

    @RequestMapping(value="/concert", method = RequestMethod.POST)
    public String processConcert(@ModelAttribute("concert") Concert concert) {
        System.out.println(concert);

        return "redirect:index.html";
    }


}
