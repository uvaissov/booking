package kz.astana.uvaissov.booking.entity;

import javax.persistence.*;


import java.sql.Date;


/**
 * The persistent class for the client_info database table.
 * 
 */
@Entity
@Table(name="client_info")
@NamedQuery(name="ClientInfo.findAll", query="SELECT c FROM ClientInfo c")
public class ClientInfo {

	@Id
	@Column(name="info_id")
	private Long infoId;
	
	@Column(name="apt")
	private String apt;
	
	@Column(name="bik")
	private String bik;

	@Column(name="ceo_firstname")
	private String ceoFirstname;

	@Column(name="ceo_patronymic")
	private String ceoPatronymic;

	@Column(name="ceo_surname")
	private String ceoSurname;
	
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="city_id")
	private DictCity city;
	
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="country_id")
	private DictCountry country;
	
	@Column(name="home")
	private String home;
	
	@Column(name="iik")
	private String iik;

	@Column(name="iin_bin")
	private String iinBin;
	
	@Basic
	@Column(name="license_date")
	private Date  licenseDate;

	@Column(name="license_num")
	private String licenseNum;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phone")
	private String phone;

	@Column(name="prefix")
	private String prefix;

	@Column(name="street")
	private String street;
	
	@Column(name="bankname")
	private String bankName;

	public ClientInfo() {
	}

	public Long getInfoId() {
		return this.infoId;
	}

	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}

	public String getApt() {
		return this.apt;
	}

	public void setApt(String apt) {
		this.apt = apt;
	}

	public String getBik() {
		return this.bik;
	}

	public void setBik(String bik) {
		this.bik = bik;
	}

	public String getCeoFirstname() {
		return this.ceoFirstname;
	}

	public void setCeoFirstname(String ceoFirstname) {
		this.ceoFirstname = ceoFirstname;
	}

	public String getCeoPatronymic() {
		return this.ceoPatronymic;
	}

	public void setCeoPatronymic(String ceoPatronymic) {
		this.ceoPatronymic = ceoPatronymic;
	}

	public String getCeoSurname() {
		return this.ceoSurname;
	}

	public void setCeoSurname(String ceoSurname) {
		this.ceoSurname = ceoSurname;
	}

	public DictCity getCity() {
		return city;
	}

	public void setCity(DictCity city) {
		this.city = city;
	}

	public DictCountry getCountry() {
		return country;
	}

	public void setCountry(DictCountry country) {
		this.country = country;
	}

	public String getHome() {
		return this.home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getIik() {
		return this.iik;
	}

	public void setIik(String iik) {
		this.iik = iik;
	}

	public String getIinBin() {
		return this.iinBin;
	}

	public void setIinBin(String iinBin) {
		this.iinBin = iinBin;
	}

	public Date getLicenseDate() {
		return this.licenseDate;
	}

	public void setLicenseDate(Date licenseDate) {
		this.licenseDate = licenseDate;
	}

	public String getLicenseNum() {
		return this.licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

}