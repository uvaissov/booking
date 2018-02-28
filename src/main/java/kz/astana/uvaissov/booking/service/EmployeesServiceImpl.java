package kz.astana.uvaissov.booking.service;


import java.util.List;

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
public class EmployeesServiceImpl implements EmployeesService{

	@Autowired
	private EmployeesRepository employeesRepository;
	
	@Override
	public List<Employees> findByClientId(Long clientId) {
		return employeesRepository.findByClientIdOrderById(clientId);
	}

	@Override
	public void save(Employees emp) {
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