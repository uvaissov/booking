package kz.astana.uvaissov.booking.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kz.astana.uvaissov.booking.entity.User;
import kz.astana.uvaissov.booking.service.UserService;
import kz.astana.uvaissov.booking.workspace.model.NavItem;

@Controller
@SessionAttributes("user")
@RequestMapping("/setting")
public class SettingController {

	@Autowired
	private UserService userService;
	
	

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView setting(@ModelAttribute("user") User user,HttpSession session) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println("userName"+ user.getName() + " " + user.getLastName());
		
		List<NavItem> fromAttrib = (List<NavItem>) session.getAttribute("navItems");
		if(fromAttrib!=null) {
		for(NavItem item: fromAttrib) {
			System.out.println(item.getItemName());
		}
		} else {
			System.out.println("fromAttrib is null");
		}
		List<NavItem> navItems = new ArrayList<NavItem>();
		navItems.add(new NavItem("Основная информация", "mainInfo", true, "left"));
		navItems.add(new NavItem("Сотрудник", "employees", false, "left"));
		navItems.add(new NavItem("Должности", "position", false, "left"));
		navItems.add(new NavItem("Расписание", "shedulle", false, "left"));
		modelAndView.addObject("tabsItems", navItems);
		modelAndView.setViewName("/workspace/container/setting/setting");
		return modelAndView;
	}
	
	 @RequestMapping("/mainInfo")
	 public String mainInfo(){
	    	return "/workspace/container/setting/mainInfo";
	 }
	 @RequestMapping("/employees")
	 public String employees_list(){
	    	return "/workspace/container/setting/employees";
	 }
	 @RequestMapping("/position")
	 public String position_list(){
		 return "/workspace/container/setting/position";
	 }
	 
	 @RequestMapping("/shedulle")
	 public String shedulle_list(){
		 return "/workspace/container/setting/sheduller";
	 }
}
