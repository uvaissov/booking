package kz.astana.uvaissov.booking.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kz.astana.uvaissov.booking.model.User;
import kz.astana.uvaissov.booking.service.UserService;
import kz.astana.uvaissov.booking.workspace.model.NavItem;

@Controller
public class IndexController {

	@Autowired
	private UserService userService;
	

    @RequestMapping(value = {"/index","/workspace"}, method = RequestMethod.GET)
    public ModelAndView workspace(Model model) {
    	ModelAndView modelAndView = new ModelAndView();
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	User user = userService.findUserByEmail(auth.getName());
    	modelAndView.addObject("userName", user.getName() + " " + user.getLastName());
    	
    	List<NavItem> navItems = new ArrayList<NavItem>();
    	navItems.add(new NavItem("График", "calendar.html", true));
    	navItems.add(new NavItem("Клиенты", "calendar.html", false));
    	navItems.add(new NavItem("Услуги", "calendar.html", false));
    	navItems.add(new NavItem("Склад", "calendar.html", false));
    	navItems.add(new NavItem("Отчеты", "calendar.html", false));
    	modelAndView.addObject("navItems",navItems);
		modelAndView.setViewName("index");
		return modelAndView;
    }
    
   
}
