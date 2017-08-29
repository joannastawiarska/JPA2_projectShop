package com.capgemini.domain;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.capgemini.datatype.Address;

@Entity
@Table(name = "CLIENT")
public class ClientEntity extends AbstractEntity {

	@Column(nullable = false, length = 20)
    private String name;
	
	@Column(nullable = false, length = 20)
    private String surname;
	
	@Column(nullable = false, length = 30)
    private String email;
	
	@Column(nullable = false, length = 	30)
    private String phoneNumber;
	
	@Column(nullable = false)
    private Date dateOfBirth;
	
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy = "client")
	private Set<TransactionEntity> transactions;
	
	public ClientEntity() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}
