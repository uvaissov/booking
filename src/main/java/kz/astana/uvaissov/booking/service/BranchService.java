package kz.astana.uvaissov.booking.service;

import java.util.List;

import kz.astana.uvaissov.booking.entity.Branch;

public interface BranchService {
	List<Branch> findByClientId(Long clientId) ;
	void save(Branch branch);
	Branch update(Branch branch);
	void remove(Long id);
}
