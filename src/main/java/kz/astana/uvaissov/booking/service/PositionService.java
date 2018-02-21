package kz.astana.uvaissov.booking.service;

import java.util.List;

import kz.astana.uvaissov.booking.entity.Position;

public interface PositionService {
	public void savePosition(Position position);
	public Position updatePosition(Position position);
	public List<Position> findByClientId(Long clientId) ;
	public void removePosition(Long id);
}
