package kz.astana.uvaissov.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.astana.uvaissov.booking.entity.Position;


@Repository("positionRepository")
public interface PositionRepository extends JpaRepository<Position, Integer>{
	List<Position> findByClientId(Long clientId);

}