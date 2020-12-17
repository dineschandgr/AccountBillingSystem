package com.user.account.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Account")
@Getter @Setter @NoArgsConstructor
@ToString
@AllArgsConstructor
public class Account {

	@Id
	@Column(name="account_id")
	private String accountId;
	
	@Column(name="account_number")
	private Long number;
	
	@Column(name="account_type")
	private String type;
	
	//@Column(name="address",nullable = false)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="userId", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "account")
	private List<Bill> bills;*/
}
