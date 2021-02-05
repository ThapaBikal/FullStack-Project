package com.backend.users.service;

import com.backend.users.shared.UserDto;

public interface UsersService {
	UserDto createUser(UserDto userDetails);
}
