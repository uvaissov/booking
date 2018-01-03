package kz.astana.uvaissov.booking.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kz.astana.uvaissov.booking.model.User;

@Controller
public class IndexController {

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Ваш логин или пароль не верны");

        if (logout != null)
            model.addAttribute("message", "Вы вышли");

        return "login";
    }

    @RequestMapping(value = {"/","/workspace"}, method = RequestMethod.GET)
    public String workspace(Model model) {
    	
        return "workspace";
    }
    
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }
}
