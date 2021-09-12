package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.LoginUser;

public interface LoginDAO extends JpaRepository<LoginUser, Integer>{
	
	LoginUser findByCustIDAndPass(int custID, String pass);

}
