package kz.astana.uvaissov.booking.service;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.astana.uvaissov.booking.entity.ClientInfo;
import kz.astana.uvaissov.booking.repository.InfoRepository;

@Service("infoService")
public class InfoServiceImpl implements InfoService{

	
	@Autowired
	private InfoRepository infoRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public ClientInfo findByInfoId(Long infoId) {
		return infoRepository.findByInfoId(infoId);
	}

	@Override
	public void save(ClientInfo info) {
		em.refresh(info.getCity());
		em.refresh(info.getCountry());
		infoRepository.save(info);
		
	}
	@Override
	public ClientInfo update(ClientInfo emp) {
		return infoRepository.save(emp);
	}
	
	

}
