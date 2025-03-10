package com.wipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.wipro.entity.User;
import com.wipro.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserRepo userRepo;
	
	@Override
	public User createUser(User u) {
		return userRepo.save(u);
	}

	@Override
	public Optional<User> getByUserId(int id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id);
	}

	@Override
	public User updateUser(int id, User u) {
		// TODO Auto-generated method stub
		User oldUser = userRepo.findById(id).get();
		if (oldUser != null)
		{
			oldUser.setName(u.getName());
			oldUser.setSalary(u.getSalary());
			oldUser.setDesignation(u.getDesignation());
			return userRepo.save(oldUser);
		}
		else
			return null;
	}

	@Override
	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		User oldUser = userRepo.findById(id).get();
		if (oldUser == null)
		{
			System.out.println("No such record");
		}
		else
			userRepo.deleteById(id);		
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
}
