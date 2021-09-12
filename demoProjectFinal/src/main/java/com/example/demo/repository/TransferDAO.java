package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.*;

import com.example.demo.model.TransferMoney;

public interface TransferDAO extends JpaRepository<TransferMoney, String>{
	
	@Query("from TransferMoney where fromAC=?1")
	List<TransferMoney> getTxnList(String acno);

}
