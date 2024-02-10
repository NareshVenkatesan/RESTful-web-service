package com.NV.springboot.Service;

import java.util.List;

import com.NV.springboot.dto.UserDto;
import com.NV.springboot.entity.User;

public interface UserService {
	
	UserDto createUser(UserDto user);
	
	UserDto getUserById(Long userId);
	
	List<UserDto> getAllUsers();
	
	UserDto upadateUser(UserDto user);
	
	void deleteUser(Long userId);

}
