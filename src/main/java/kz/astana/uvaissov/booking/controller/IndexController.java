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
	

    @RequestMapping(value = {"/workspace"}, method = RequestMethod.GET)
    public ModelAndView workspace(Model model) {
    	ModelAndView modelAndView = new ModelAndView();
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	User user = userService.findUserByEmail(auth.getName());
    	modelAndView.addObject("userName", user.getName() + " " + user.getLastName());
    	
    	List<NavItem> navItems = new ArrayList<NavItem>();
    	navItems.add(new NavItem("График", "calendar", true));
    	navItems.add(new NavItem("Клиенты", "clients", false));
    	navItems.add(new NavItem("Услуги", "calendar", false));
    	navItems.add(new NavItem("Склад", "calendar", false));
    	navItems.add(new NavItem("Отчеты", "reports", false));
    	modelAndView.addObject("navItems",navItems);
		modelAndView.setViewName("/workspace/main");
		return modelAndView;
    }
    
    @RequestMapping("/workspace/container/calendar")
    public String calendar(){
    	return "/workspace/container/calendar";
    }
    @RequestMapping("/workspace/container/clients")
    public String clients(){
    	return "/workspace/container/clients";
    }
    @RequestMapping("/workspace/container/reports")
    public String reports(){
    	return "/workspace/container/reports";
    }
    
   
}
