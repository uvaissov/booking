package kz.astana.uvaissov.booking.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.astana.uvaissov.booking.entity.Client;
import kz.astana.uvaissov.booking.entity.Position;
import kz.astana.uvaissov.booking.entity.User;
import kz.astana.uvaissov.booking.repository.ClientRepository;
import kz.astana.uvaissov.booking.repository.PositionRepository;

@Service("positionService")
public class PositionServiceImpl implements PositionService{

	@Autowired
	private PositionRepository positionRepository;
	
	@Override
	public List<Position> findByClientId(Long clientId) {
		return positionRepository.findByClientId(clientId);
	}

	@Override
	public void savePosition(Position position) {
		positionRepository.save(position);
		
	}
	@Override
	public Position updatePosition(Position position) {
		return positionRepository.save(position);
	}

}
