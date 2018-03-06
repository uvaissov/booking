package kz.astana.uvaissov.booking.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dict_city database table.
 * 
 */
@Entity
@Table(name="dict_city")
@NamedQuery(name="DictCity.findAll", query="SELECT d FROM DictCity d")
public class DictCity {
 
	@Id
	@Column(name="city_id")
	private Long cityId;

	@Column(name="country_id")
	private Long countryId;

	private String name;

	public DictCity() {
	}

	public Long getCityId() {
		return this.cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}