package com.wipro.service;

import java.util.List;
import java.util.Optional;

import com.wipro.entity.User;

public interface UserService {
	User createUser(User u);
	Optional<User> getByUserId(int id);
	User updateUser(int id, User u);
	void deleteUserById(int id);
	List<User> findAll();
}