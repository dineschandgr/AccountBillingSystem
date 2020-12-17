package com.user.account.service;

import java.time.LocalDate;
import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.user.account.model.Account;
import com.user.account.model.Bill;
import com.user.account.model.User;
import com.user.account.repository.AccountRepository;
import com.user.account.repository.BillRepository;
import com.user.account.repository.UserRepository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	BillRepository billRepository;
	
	public void saveUser(){
		User u1 = new User();
		u1.setId("1");
		u1.setContactNo("83471025");
		u1.setName("DC");
		u1.setDateOfBirth(LocalDate.parse("28-04-1988"));
		String generatedBills = "25,12,34,56,78";
		Bill bill = new Bill();
		bill.setBillId("1");
		bill.setAmount(25f);
		bill.setMonth(12);
		bill.setYear(2020);
		bill.setGeneratedBills(generatedBills);
		
		Account account = new Account("1",12345678L,"commercial",u1);
		
		bill.setAccount(account);
		u1.setAccount(Arrays.asList(account));
		
		userRepository.save(u1);
		billRepository.save(bill);
		
		User user = userRepository.findById("1").orElseGet(null);
		System.out.println("************************************************ "+user);		
		user.getAccount().forEach(account1 -> System.out.println(account));
		System.out.println("************************************************///////////////");
		accountRepository.findAll().forEach(System.out::println);
		Pageable pageable = PageRequest.of(0, 2,Sort.by("number").descending());
		accountRepository.findByUserId("1").forEach( account2 -> {
			System.out.println("paginated and sorted "+account2);
		});
		accountRepository.findByUserId("1", pageable).forEach( account2 -> {
			System.out.println("paginated and sorted "+account2);
		});
		
		System.out.println(" bill account ************************************************///////////////");
		billRepository.findAll().forEach(bill1 -> {
			System.out.println(bill1.getAccount());
			System.out.println(bill1.getAccount().getUser().getName());
		});
	}
	
}
