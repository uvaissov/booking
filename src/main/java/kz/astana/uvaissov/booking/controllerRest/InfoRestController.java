package kz.astana.uvaissov.booking.controllerRest;

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
import kz.astana.uvaissov.booking.repository.GsonHttp;
import kz.astana.uvaissov.booking.service.ClientService;
import kz.astana.uvaissov.booking.service.InfoService;

@RestController()
@SessionAttributes({"user","client"})
@RequestMapping("/setting/mainInfo")
public class InfoRestController {
	
	@Autowired
	private InfoService infoService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private GsonHttp gson;
	
	@GetMapping
	public ClientInfo getInfo(@ModelAttribute("client") Client client){
		System.out.println("infoId:"+client.getInfoId());
		return infoService.findByInfoId(client.getInfoId());
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity save(@ModelAttribute("client") Client client, @RequestBody ClientInfo info) {
		infoService.save(info);
		if (null == info.getInfoId()) {
			return new ResponseEntity("No ClientInfo found for ID ", HttpStatus.NOT_FOUND);
		}
		if(client.getInfoId()==null) {
			client.setInfoId(info.getInfoId());
			clientService.saveClient(client);
		}
		return new ResponseEntity(info, HttpStatus.OK);
	}

	
	@PutMapping("/{id}")
	public ResponseEntity update(@PathVariable Long id,@RequestBody ClientInfo info) {
		info = infoService.update(info);
		if (null == info) {
			return new ResponseEntity("No ClientInfo found for ID " + info.getInfoId()
			, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(info, HttpStatus.OK);
	}
}
