package kz.astana.uvaissov.booking.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kz.astana.uvaissov.booking.entity.Employees;
import kz.astana.uvaissov.booking.entity.Position;


@Repository("employeesRepository")
public interface EmployeesRepository extends JpaRepository<Employees, Integer>{
	
	@Query("select e from Employees e where e.clientId =? order by e.id")
	List<Employees> findByClientIdOrderById(Long clientId);
	
	@Transactional
	void deleteEmployeesById(Long id);
}