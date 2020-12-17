package com.user.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Bill")
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bill {

	@Id
	@Column(name="bill_id")
	private String billId;
	
	@Column(name="year")
	private int year;
	
	@Column(name="month")
	private int month;
	
	@Column(name="amount")
	private float amount;
	
	@Lob
	@Column(name = "generated_bills", columnDefinition = "CLOB")
	private String generatedBills;
	
	//@Column(name="address",nullable = false)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="accountId", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Account account;
	
	
}
