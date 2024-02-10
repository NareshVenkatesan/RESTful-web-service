package com.NV.springboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.NV.springboot.dto.UserDto;
import com.NV.springboot.entity.User;

@Mapper
public interface AutoUserMapper {
	
	AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
	
	UserDto mapToUserDto(User user);
	
	
	User mapToUser(UserDto userDto);

}