package com.user.account.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="User")
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@Column(name="user_id")
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="contact_no")
	private String contactNo;
	
	@Column(name="DOB")
	private LocalDate dateOfBirth;
	
	
	//@Column(name="address",nullable = false)
	/*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
	private Address address;*/
	
	/*@OneToMany(mappedBy="user")
	 * 
	private Account account;*/
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	private List<Account> account;


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", contactNo=" + contactNo + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	
}
