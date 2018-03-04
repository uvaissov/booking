package kz.astana.uvaissov.booking.service;

import kz.astana.uvaissov.booking.entity.ClientInfo;
import kz.astana.uvaissov.booking.entity.DictCity;
import kz.astana.uvaissov.booking.entity.DictCountry;

public interface InfoService {
	ClientInfo findByInfoId(Long infoId) ;
	void save(ClientInfo info);
	ClientInfo update(ClientInfo info);
}
