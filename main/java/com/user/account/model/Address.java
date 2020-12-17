package com.user.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Address")
@Getter
@Setter
@NoArgsConstructor
public class Address {

	@Id
	@Column(name="address_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String addressId;
	
	@Column(name="type", nullable = false)
	private String type;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name = "street", nullable = false)
	private String street;
	
	@Column(name = "building")
	private String building;
	
	@Column(name = "unit_no")
	private String unitNo;
	
	@Column(name = "floor")
	private String floor;
	
	@OneToOne
	@JoinColumn(name="user_id", nullable=false)
    private User user;
}
