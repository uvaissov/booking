package kz.astana.uvaissov.booking.service;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.astana.uvaissov.booking.entity.Branch;
import kz.astana.uvaissov.booking.entity.Client;
import kz.astana.uvaissov.booking.entity.Employees;
import kz.astana.uvaissov.booking.entity.Position;
import kz.astana.uvaissov.booking.entity.User;
import kz.astana.uvaissov.booking.repository.BranchRepository;
import kz.astana.uvaissov.booking.repository.ClientRepository;
import kz.astana.uvaissov.booking.repository.EmployeesRepository;


@Service("branchService")
public class BranchServiceImpl implements BranchService{

	@Autowired
	private BranchRepository branchRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Branch> findByClientId(Long clientId) {
		return branchRepository.findByClientIdOrderById(clientId);
	}

	@Override
	public void save(Branch branch) {
		branchRepository.save(branch);
		
	}
	@Override
	public Branch update(Branch branch) {
		return branchRepository.save(branch);
	}
	
	@Override
	public void remove(Long id) {
		branchRepository.deleteById(id);
	}
	

}
