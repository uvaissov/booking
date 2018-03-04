package kz.astana.uvaissov.booking.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dict_country database table.
 * 
 */
@Entity
@Table(name="dict_country")
@NamedQuery(name="DictCountry.findAll", query="SELECT d FROM DictCountry d")
public class DictCountry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="country_id")
	private Long countryId;

	private String abbr;

	private String code;

	private String name;

	public DictCountry() {
	}

	public Long getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getAbbr() {
		return this.abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}