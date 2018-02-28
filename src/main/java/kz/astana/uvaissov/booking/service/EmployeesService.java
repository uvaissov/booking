package kz.astana.uvaissov.booking.service;

import java.util.List;

import kz.astana.uvaissov.booking.entity.Employees;
import kz.astana.uvaissov.booking.entity.Position;

public interface EmployeesService {
	List<Employees> findByClientId(Long clientId) ;
	void save(Employees emp);
	Employees update(Employees emp);
	void remove(Long id);
}
