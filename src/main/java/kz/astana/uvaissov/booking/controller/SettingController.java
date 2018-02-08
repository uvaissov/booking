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
@RequestMapping("/setting")
public class SettingController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView workspace(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", user.getName() + " " + user.getLastName());

		List<NavItem> navItems = new ArrayList<NavItem>();
		navItems.add(new NavItem("Основная информация", "mainInfo", true, "left"));
		navItems.add(new NavItem("Сотрудник", "employees-list", false, "left"));
		navItems.add(new NavItem("Должности", "position-list", false, "left"));
		navItems.add(new NavItem("Расписание", "shedulle-list", false, "left"));
		modelAndView.addObject("tabsItems", navItems);
		modelAndView.setViewName("/workspace/container/setting/setting");
		return modelAndView;
	}
	
	 @RequestMapping("/mainInfo")
	 public String mainInfo(){
	    	return "/workspace/container/setting/mainInfo";
	 }
	 @RequestMapping("/employees-list")
	 public String employees_list(){
	    	return "/workspace/container/setting/employees/list";
	 }
	 @RequestMapping("/employees-add")
	 public String employees_add(){
		 return "/workspace/container/setting/employees/add";
	 }
	 @RequestMapping("/position-list")
	 public String position_list(){
		 return "/workspace/container/setting/employees/list";
	 }
	 @RequestMapping("/position-add")
	 public String position_add(){
		 return "/workspace/container/setting/employees/add";
	 }
	 @RequestMapping("/shedulle-list")
	 public String shedulle_list(){
		 return "/workspace/container/setting/employees/list";
	 }
}
