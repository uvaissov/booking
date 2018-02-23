package kz.astana.uvaissov.booking.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "employees")
public class Employees {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_id")
	private Long id;
	
	@Column(name="client_id")
	private Long clientId;
	
	@Column(name="fitstName")
	private String fitstName;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="patronymic")
	private String patronymic;
	
	@Column(name="phone")
	private Long phone;
	
	@Column(name="position_id")
	private Long position_id;
	
	@Column(name="description")
	private String description;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "branch_employees_ref", joinColumns = @JoinColumn(name = "emp_id"), inverseJoinColumns = @JoinColumn(name = "branch_id"))
	private Set<Branch> branches;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getFitstName() {
		return fitstName;
	}

	public void setFitstName(String fitstName) {
		this.fitstName = fitstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Long getPosition_id() {
		return position_id;
	}

	public void setPosition_id(Long position_id) {
		this.position_id = position_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Branch> getBranches() {
		return branches;
	}

	public void setBranches(Set<Branch> branches) {
		this.branches = branches;
	}
}