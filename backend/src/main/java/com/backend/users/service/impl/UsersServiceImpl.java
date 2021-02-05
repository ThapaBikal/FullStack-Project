package com.backend.users.service.impl;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.data.UserEntity;
import com.backend.repository.UserRepository;
import com.backend.users.service.UsersService;
import com.backend.users.shared.UserDto;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDetails) {

		// this will generate universal unique identification
		userDetails.setStudentId(UUID.randomUUID().toString());
		userDetails.setEncryptedPassword("test123");
		ModelMapper modelMaper = new ModelMapper();
		modelMaper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
//		// modelMaper.map will map object from source to destinatination and fieldname must match
		UserEntity userEntity = modelMaper.map(userDetails, UserEntity.class);
		
		userRepository.save(userEntity);
		
		UserDto returnValue = modelMaper.map(userEntity, UserDto.class);
		return returnValue;
		
	}

}
