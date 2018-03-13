package kz.astana.uvaissov.booking.service;

import java.util.List;

import kz.astana.uvaissov.booking.entity.ClientInfo;
import kz.astana.uvaissov.booking.entity.DictCity;
import kz.astana.uvaissov.booking.entity.DictCountry;

public interface DictService {

	List<DictCountry> getCountries();

	List<DictCity> getCityes(Long countryId);
}
