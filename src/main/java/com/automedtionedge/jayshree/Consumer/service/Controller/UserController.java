package com.automedtionedge.jayshree.Consumer.service.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.automedtionedge.jayshree.Consumer.service.Model.User;
import com.automedtionedge.jayshree.Consumer.service.Service.UserServiceImpl;
import com.automedtionedge.jayshree.Consumer.service.UserDTO.UserDTO;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserServiceImpl userServiceImpl;

	public UserController(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	@PostMapping("/userData")
	public UserDTO createUser(@RequestBody UserDTO userDTO) {
		UserDTO registerUser = userServiceImpl.registerUser(userDTO);
		return registerUser;

	}

	@GetMapping("/Users")
	public List<User> getAllUSer() {
		List<User> allUser = userServiceImpl.getAllUser();
		return allUser;

	}

	@GetMapping("/login/{password}")
	public String getUser(@PathVariable String password) {
		String loginUser = userServiceImpl.loginUser(password);
		return "User Loging Successfully";

	}

	@DeleteMapping("/reset/{id}")
    public String resetUser(@PathVariable Long id) {
		String deleteUserById = userServiceImpl.deleteUserById(id);
		return "User Deleted Successfully";
	}

}
