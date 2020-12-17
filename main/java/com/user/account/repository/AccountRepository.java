package com.user.account.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.account.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String>{
	List<Account> findByUserId(String userId, Pageable pageable);
	List<Account> findByUserId(String userId);
}
