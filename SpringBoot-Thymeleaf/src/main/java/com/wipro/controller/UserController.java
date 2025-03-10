package com.wipro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.entity.User;
import com.wipro.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String getAllUsers(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "user-list";
	}
	
	@GetMapping("/new")
	public String showCreateForm(Model model) {
		model.addAttribute("user", new User());
		return "create-user";
	}
	
	@PostMapping
	public String createUser(User user) {
		userService.createUser(user);
		return "redirect:/users";
	}
	
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id") int userId, Model model) {
	    Optional<User> userOptional = userService.getByUserId(userId);
	    
	    if (userOptional.isPresent()) {
	        model.addAttribute("user", userOptional.get());
	        return "update-user";
	    } else {
	        return "redirect:/users"; 
	    }
	}
	
	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") int userId, User user) {
		user.setId(userId);
		userService.updateUser(userId, user);
		return "redirect:/users";
	}
	
	@GetMapping("/{id}")
	public String viewUser(@PathVariable("id") int userId, Model model) {
	    Optional<User> userOptional = userService.getByUserId(userId);
	    
	    // Check if user exists
	    if (userOptional.isPresent()) {
	        model.addAttribute("user", userOptional.get());
	        return "user-detail";
	    } else {
	        return "redirect:/users";
	    }
	}

	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int userId) {
		userService.deleteUserById(userId);
		return "redirect:/users";
	}
}
	