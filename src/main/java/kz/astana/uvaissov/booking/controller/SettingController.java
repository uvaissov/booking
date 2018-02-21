package kz.astana.uvaissov.booking.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kz.astana.uvaissov.booking.entity.Client;
import kz.astana.uvaissov.booking.entity.Position;
import kz.astana.uvaissov.booking.entity.Role;
import kz.astana.uvaissov.booking.entity.User;
import kz.astana.uvaissov.booking.repository.GsonHttp;
import kz.astana.uvaissov.booking.service.PositionService;
import kz.astana.uvaissov.booking.service.UserService;
import kz.astana.uvaissov.booking.workspace.model.NavItem;

@Controller
@SessionAttributes("user")
@RequestMapping("/setting")
public class SettingController {

	@Autowired
	private UserService userService;

	@Autowired
	private PositionService positionService;
	
	@Autowired
	private GsonHttp gson;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView setting(@ModelAttribute("user") User user, HttpSession session) {

		ModelAndView modelAndView = new ModelAndView();

		System.out.println("userName:" + user.getName() + " " + user.getLastName());
		for (Role role : user.getRoles()) {
			System.out.println(role.getRole());
		}

		List<NavItem> navItems = new ArrayList<NavItem>();
		navItems.add(new NavItem("Основная информация", "mainInfo_page", true, "left"));
		navItems.add(new NavItem("Сотрудник", "employees_page", false, "left"));
		navItems.add(new NavItem("Должности", "position_page", false, "left"));
		navItems.add(new NavItem("Расписание", "shedulle_page", false, "left"));
		modelAndView.addObject("tabsItems", navItems);
		modelAndView.setViewName("/workspace/container/setting/setting");
		return modelAndView;
	}

	@GetMapping("/mainInfo_page")
	public String mainInfo() {
		return "/workspace/container/setting/mainInfo";
	}

	@GetMapping("/employees_page")
	public String employees_list() {
		return "/workspace/container/setting/employees";
	}

	@GetMapping("/shedulle_page")
	public String shedulle_page() {
		return "/workspace/container/setting/sheduller";
	}

	@GetMapping("/position_page")
	public String position_page() {
		return "/workspace/container/setting/position";
	}

}
