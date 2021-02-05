package com.backend.ui.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.data.UserEntity;
import com.backend.ui.model.request.UserDetailsRequestModel;
import com.backend.ui.model.response.UserResponse;
import com.backend.users.service.UsersService;
import com.backend.users.shared.UserDto;

@RestController
@RequestMapping("students") // http://locolhost:8080/students
public class UserController {

	@Autowired
	UsersService userService;

	@GetMapping
	public String getStudents(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {

		return "getting all students...page: " + page + " and limit " + limit + " sort=" + sort;
	}

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getstudent(@PathVariable String id) {
		UserResponse returnValue = new UserResponse();

		return new ResponseEntity<UserResponse>(returnValue, HttpStatus.OK);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> createStudent(@Valid @RequestBody UserDetailsRequestModel userDetails) {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserDto userDto = modelMapper.map(userDetails, UserDto.class);
		UserDto createdUser =  userService.createUser(userDto);
		
		UserResponse returnValue = modelMapper.map(createdUser, UserResponse.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);

	}

	@DeleteMapping
	public String deleteStudent() {
		return "deleting students...";
	}

	@PutMapping
	public String updateStudent() {
		return "updating students...";
	}

	@PatchMapping
	public String patchStudent() {
		return "patch students...";
	}

}
