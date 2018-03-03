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

import kz.astana.uvaissov.booking.entity.Branch;
import kz.astana.uvaissov.booking.entity.Client;
import kz.astana.uvaissov.booking.entity.Position;
import kz.astana.uvaissov.booking.repository.GsonHttp;
import kz.astana.uvaissov.booking.service.BranchService;
import kz.astana.uvaissov.booking.service.PositionService;
import kz.astana.uvaissov.booking.service.UserService;

@RestController()
@SessionAttributes({"user","client"})
@RequestMapping("/setting/branch")
public class BranchRestController {
	
	@Autowired
	private BranchService branchService;
	
	@Autowired
	private GsonHttp gson;
	
	@GetMapping
	public List<Branch> getBranches(@ModelAttribute("client") Client client){
		return branchService.findByClientId(client.getId());
	}
	
	@PostMapping
	public ResponseEntity save(@ModelAttribute("client") Client client, @RequestBody Branch branch) {
		branch.setClientId(client.getId());
		branchService.save(branch);
		if (null == branch.getId()) {
			return new ResponseEntity("No Branch found for ID ", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(branch, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		if (id == null) {
			return new ResponseEntity("No Branch found for ID " + id, HttpStatus.NOT_FOUND);
		}
		branchService.remove(id);
		return new ResponseEntity(id, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity update(@PathVariable Long id,@RequestBody Branch branch) {
		branch = branchService.update(branch);
		if (null == branch) {
			return new ResponseEntity("No Branch found for ID " + branch.getId()
			, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(branch, HttpStatus.OK);
	}
}
