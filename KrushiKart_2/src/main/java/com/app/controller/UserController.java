package com.app.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DeleteAccountDto;
import com.app.dto.Userdto;
import com.app.service.user.IUserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
@Slf4j
public class UserController {
	
	//dependency injection
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ModelMapper mapper;
	
	@PutMapping("/user/update")
	public ResponseEntity<?> updateExistingUser(@RequestBody Userdto userDTOObj){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateExistingUser(userDTOObj));
	}
	
	@DeleteMapping("/user/delete") 
	public String deleteUserDetails(@RequestBody DeleteAccountDto account) {
		
		return userService.deleteUserDetails(account);
	}

}
