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
@RequestMapping("/workspace")
public class WorkspaceController {

	@Autowired
	private UserService userService;
	

    @RequestMapping( method = RequestMethod.GET)
    public ModelAndView workspace(Model model) {
    	ModelAndView modelAndView = new ModelAndView();
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	User user = userService.findUserByEmail(auth.getName());
    	modelAndView.addObject("userName", user.getName() + " " + user.getLastName());
    	
    	List<NavItem> navItems = new ArrayList<NavItem>();
    	navItems.add(new NavItem("График", "calendar", true,"left"));
    	navItems.add(new NavItem("Клиенты", "clients", false,"left"));
    	navItems.add(new NavItem("Услуги", "calendar", false,"left"));
    	navItems.add(new NavItem("Склад", "calendar", false,"left"));
    	navItems.add(new NavItem("Отчеты", "reports", false,"left"));
    	navItems.add(new NavItem("Настройки", "setting", false,"right"));
    	modelAndView.addObject("navItems",navItems);
		modelAndView.setViewName("/workspace/main");
		return modelAndView;
    }
    
    @RequestMapping("/container/calendar")
    public String calendar(){
    	return "/workspace/container/calendar";
    }
    @RequestMapping("/container/clients")
    public String clients(){
    	return "/workspace/container/clients";
    }
    @RequestMapping("/container/reports")
    public String reports(){
    	return "/workspace/container/reports";
    }
    
    @RequestMapping("/container/setting")
    public String setting(){
    	return "/workspace/container/setting";
    }
   
}
