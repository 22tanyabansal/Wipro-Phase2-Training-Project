package com.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{ 

} 
