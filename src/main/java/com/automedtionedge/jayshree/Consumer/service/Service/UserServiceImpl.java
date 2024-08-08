package com.automedtionedge.jayshree.Consumer.service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.automedtionedge.jayshree.Consumer.service.Enum.Role;
import com.automedtionedge.jayshree.Consumer.service.Model.User;
import com.automedtionedge.jayshree.Consumer.service.Repository.UserRepository;
import com.automedtionedge.jayshree.Consumer.service.UserDTO.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {

		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDTO registerUser(UserDTO userDTO) {

		User user = getUserDTO(userDTO);

		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		User saveUser = userRepository.save(user);

		UserDTO responseUser = getUserEntity(saveUser);

		return responseUser;
	}

	@Override
	public List<User> getAllUser() {
		List<User> allUser = userRepository.findAll();
		List<UserDTO> Userlist = new ArrayList<UserDTO>();
		for (User user : allUser) {
			UserDTO user1 = getUserEntity(user);
			Userlist.add(user1);
		}

		return allUser;
	}

	@Override
	public String loginUser(String password) {

		Optional<User> byPassword = userRepository.findByPassword(password);
		if (byPassword.isEmpty()) {

			return "Invalid  password.";
		}
		User user = byPassword.get();
		if (!passwordEncoder.matches(password, user.getPassword())) {
			return "Invalid  password.";
		}
		return "Login Successfully";

	}

	@Override
	public String deleteUserById(Long id) {

		userRepository.deleteById(id);

		return "User Reset Successfully";
	}

	private static UserDTO getUserEntity(User saveUser) {
		UserDTO responseUser = new UserDTO();
		responseUser.setEmpId(saveUser.getEmpId());
		responseUser.setMobile(saveUser.getMobile());
		responseUser.setName(saveUser.getName());
		responseUser.setPassword(saveUser.getPassword());
		responseUser.setRole(saveUser.getRole());
		return responseUser;
	}

	private static User getUserDTO(UserDTO userDTO) {
		User user = new User();
		user.setEmpId(userDTO.getEmpId());
		user.setMobile(userDTO.getMobile());
		user.setName(userDTO.getName());
		user.setPassword(userDTO.getPassword());
		user.setRole(Role.valueOf(userDTO.getRole()));
		return user;
	}

}
