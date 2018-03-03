package kz.astana.uvaissov.booking.service;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.astana.uvaissov.booking.entity.Client;
import kz.astana.uvaissov.booking.entity.Employees;
import kz.astana.uvaissov.booking.entity.Position;
import kz.astana.uvaissov.booking.entity.User;
import kz.astana.uvaissov.booking.repository.ClientRepository;
import kz.astana.uvaissov.booking.repository.EmployeesRepository;
import kz.astana.uvaissov.booking.repository.PositionRepository;

@Service("employeesService")
public class BranchServiceImpl implements EmployeesService{

	@Autowired
	private EmployeesRepository employeesRepository;
	
	@Autowired
	private PositionRepository positionRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Employees> findByClientId(Long clientId) {
		return employeesRepository.findByClientIdOrderById(clientId);
	}

	@Override
	public void save(Employees emp, Position position) {
		if(position!=null)
			position = positionRepository.findById(position.getId());
		emp.setPosition(position);
		employeesRepository.save(emp);
		
	}
	@Override
	public Employees update(Employees emp) {
		return employeesRepository.save(emp);
	}
	
	@Override
	public void remove(Long id) {
		employeesRepository.deleteEmployeesById(id);
	}
	

}
