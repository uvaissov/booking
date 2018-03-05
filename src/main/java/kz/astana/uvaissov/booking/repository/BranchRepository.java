package kz.astana.uvaissov.booking.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kz.astana.uvaissov.booking.entity.Branch;
import kz.astana.uvaissov.booking.entity.Employees;
import kz.astana.uvaissov.booking.entity.Position;


@Repository("branchRepository")
public interface BranchRepository extends JpaRepository<Branch, Long>{
	
	@Query("select b from Branch b where b.clientId =? order by b.id")
	List<Branch> findByClientIdOrderById(Long clientId);
	
	@Transactional
	void deleteById(Long id);
}