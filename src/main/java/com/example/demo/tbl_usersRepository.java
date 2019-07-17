package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface tbl_usersRepository extends JpaRepository<tbl_user, Integer> {
	tbl_user findByUsername(String username);
	
}
