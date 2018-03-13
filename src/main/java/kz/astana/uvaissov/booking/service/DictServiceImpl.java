package kz.astana.uvaissov.booking.service;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.astana.uvaissov.booking.entity.ClientInfo;
import kz.astana.uvaissov.booking.entity.DictCity;
import kz.astana.uvaissov.booking.entity.DictCountry;
import kz.astana.uvaissov.booking.repository.InfoRepository;

@Service("dictService")
public class DictServiceImpl implements DictService{

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<DictCountry> getCountries() {
		return em.createQuery("select c from DictCountry c",DictCountry.class).getResultList();
	}
	@Override
	public List<DictCity> getCityes(Long countryId) {
		return em.createQuery("select c from DictCity c where c.countryId=:id",DictCity.class)
				.setParameter("id", countryId).getResultList();
	}
}
