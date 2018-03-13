package kz.astana.uvaissov.booking.controllerRest;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import kz.astana.uvaissov.booking.entity.ClientInfo;
import kz.astana.uvaissov.booking.entity.DictCity;
import kz.astana.uvaissov.booking.entity.DictCountry;
import kz.astana.uvaissov.booking.repository.GsonHttp;
import kz.astana.uvaissov.booking.service.ClientService;
import kz.astana.uvaissov.booking.service.DictService;
import kz.astana.uvaissov.booking.service.InfoService;

@RestController()
@SessionAttributes({"user","client"})
@RequestMapping("/dictionary")
public class DictRestController {
	
	@Autowired
	private DictService dictService;
	
	@Autowired
	private GsonHttp gson;
	
	@GetMapping("/country")
	public List<DictCountry> getCountries(){
		return dictService.getCountries();
	}
	
	@GetMapping("/city/{id}")
	public List<DictCity> getCityes(@PathVariable("id") Long countryId){
		return dictService.getCityes(countryId);
	}
	
	
}
