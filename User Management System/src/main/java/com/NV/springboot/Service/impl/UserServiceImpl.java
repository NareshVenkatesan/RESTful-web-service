package com.NV.springboot.Service.impl;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

//import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.NV.springboot.Service.UserService;
import com.NV.springboot.dto.UserDto;
import com.NV.springboot.entity.User;
import com.NV.springboot.exception.EmailAlreadyExistsException;
import com.NV.springboot.exception.ResourceNotFoundException;
import com.NV.springboot.mapper.AutoUserMapper;
//import com.NV.springboot.mapper.UserMapper;
import com.NV.springboot.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	
	private UserRepository userRepository;
	
	//private ModelMapper modelMapper;

	


	@Override
	public UserDto createUser(UserDto userDto) {
		
		//User user = UserMapper.mapToUser(userDto);		
		//User user = modelMapper.map(userDto, User.class);
		
		Optional<User> optionalUser = userRepository.findByemail(userDto.getEmail());
		
		if(optionalUser.isPresent()) {
			
			throw new EmailAlreadyExistsException("Email already exists for an user");
		}
		
		User user = AutoUserMapper.MAPPER.mapToUser(userDto);

		
		User savedUser= userRepository.save(user);
		
		//UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
		//UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
		UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);

		return savedUserDto;
	}


	@Override
	public UserDto getUserById(Long userId) {
	
		//Optional<User> optionalUser = userRepository.findById(userId);
		User user = userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User","id", userId) 
				
		);

		//User user = optionalUser.get();
		//return UserMapper.mapToUserDto(user);
		//return modelMapper.map(user, UserDto.class);
		return AutoUserMapper.MAPPER.mapToUserDto(user);

	}


	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users= userRepository.findAll();
		//return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
		//return users.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		return users.stream().map((user) -> AutoUserMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());

	}


	@Override
	public UserDto upadateUser(UserDto user) {
		
		//User existingUser = userRepository.findById(user.getId()).get();
		User existingUser = userRepository.findById(user.getId()).orElseThrow(
				
				() -> new ResourceNotFoundException("User","id", user.getId())
		);

		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		//existingUser.setEmail(user.getEmailAdress());
		User updatedUser = userRepository.save(existingUser);
		//return UserMapper.mapToUserDto(updatedUser);
		//return modelMapper.map(updatedUser, UserDto.class);
		return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);

	}


	@Override
	public void deleteUser(Long userId) {
		
		User existingUser = userRepository.findById(userId).orElseThrow(
				
				() -> new ResourceNotFoundException("User","id", userId)
		);
		  
		userRepository.deleteById(userId);
		
	}




}
