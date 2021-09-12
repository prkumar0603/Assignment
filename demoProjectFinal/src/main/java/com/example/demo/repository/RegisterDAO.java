package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.RegisterUser;

public interface RegisterDAO extends JpaRepository<RegisterUser, Integer>{
	
	@Query("select pass from RegisterUser where custID=?1")
	String getCurrentPassword(int custID);
}
