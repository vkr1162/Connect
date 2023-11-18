package com.example.connect.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.connect.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer>{

	UserDetails findByEmailID(@Param("email") String email);
}
