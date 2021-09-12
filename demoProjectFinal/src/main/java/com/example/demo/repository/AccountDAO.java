package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Account;

public interface AccountDAO extends JpaRepository<Account, Integer>{
	
	@Query("from Account where acno=?1")
	Account getAccountDetails(String acno);

}
