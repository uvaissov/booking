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
import kz.astana.uvaissov.booking.entity.Position;
import kz.astana.uvaissov.booking.repository.GsonHttp;
import kz.astana.uvaissov.booking.service.PositionService;
import kz.astana.uvaissov.booking.service.UserService;

@RestController()
@SessionAttributes({"user","client"})
@RequestMapping("/setting/position")
public class PositionRestController {
	
	@Autowired
	private PositionService positionService;
	
	@Autowired
	private GsonHttp gson;
	
	@GetMapping
	public List<Position> getPostions(@ModelAttribute("client") Client client){
		return positionService.findByClientId(client.getId());
	}
	
	@PostMapping
	public ResponseEntity addPosition(@ModelAttribute("client") Client client, @RequestBody Position position) {
		//Position position = gson.getGson().fromJson(entity., Position.class);
		position.setClientId(client.getId());
		positionService.savePosition(position);
		if (null == position.getId()) {
			return new ResponseEntity("No Position found for ID ", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(position, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deletePosition(@PathVariable Long id) {
		if (id == null) {
			return new ResponseEntity("No Position found for ID " + id, HttpStatus.NOT_FOUND);
		}
		positionService.removePosition(id);
		return new ResponseEntity(id, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity updateCustomer(@PathVariable Long id,@RequestBody Position position) {

		position = positionService.updatePosition(position);

		if (null == position) {
			return new ResponseEntity("No Position found for ID " + position.getId()
			, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(position, HttpStatus.OK);
	}
}
