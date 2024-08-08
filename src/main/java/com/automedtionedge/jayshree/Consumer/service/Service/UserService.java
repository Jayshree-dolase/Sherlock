package com.automedtionedge.jayshree.Consumer.service.Service;

import java.util.List;

import com.automedtionedge.jayshree.Consumer.service.Model.User;
import com.automedtionedge.jayshree.Consumer.service.UserDTO.UserDTO;

public interface UserService {

	public UserDTO registerUser(UserDTO userDTO);

	public List<User> getAllUser();

	public String loginUser(String password);

	public String deleteUserById(Long id);

}
