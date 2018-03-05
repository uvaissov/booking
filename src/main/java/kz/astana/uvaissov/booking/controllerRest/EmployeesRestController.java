package kz.astana.uvaissov.booking.controllerRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import kz.astana.uvaissov.booking.entity.Client;
import kz.astana.uvaissov.booking.entity.Employees;
import kz.astana.uvaissov.booking.repository.GsonHttp;
import kz.astana.uvaissov.booking.service.EmployeesService;
import kz.astana.uvaissov.booking.service.UserService;

@RestController()
@SessionAttributes({"user","client"})
@RequestMapping("/setting/employees")
public class EmployeesRestController {
	
	@Autowired
	private EmployeesService employeeService;
	
	@GetMapping
	public List<Employees> getEmployees(@ModelAttribute("client") Client client){
		return employeeService.findByClientId(client.getId());
	}
	
	@PostMapping
	public ResponseEntity addPosition(@ModelAttribute("client") Client client, @RequestBody Employees emp) {
		emp.setClientId(client.getId());
		employeeService.save(emp,emp.getPosition());
		if (null == emp.getId()) {
			return new ResponseEntity("No Employees found for ID ", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(emp, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deletePosition(@PathVariable Long id) {
		if (id == null) {
			return new ResponseEntity("No Employees found for ID " + id, HttpStatus.NOT_FOUND);
		}
		employeeService.remove(id);
		return new ResponseEntity(id, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity updateCustomer(@PathVariable Long id,@RequestBody Employees emp) {

		emp = employeeService.update(emp);

		if (null == emp) {
			return new ResponseEntity("No Employees found for ID " + emp.getId()
			, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(emp, HttpStatus.OK);
	}
}
