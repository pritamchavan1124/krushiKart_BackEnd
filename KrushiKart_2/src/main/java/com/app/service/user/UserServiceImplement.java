package com.app.service.user;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import com.app.dto.Userdto;
import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.repositiory.UserRepositiory;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class UserServiceImplement implements IUserService {

//	@Autowired
//	private PasswordEncoder passwordEncoder;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserRepositiory userRepository;
	@Override
	public Userdto saveNewUser(Userdto userObj) {
	
		log.info("In user service implimentation : Save user ");
		// map dto --> entity
		User user = mapper.map(userObj, User.class);
		//user.setPassword(passwordEncoder.encode(user.getPassword()));
		User addedUser=userRepository.save(user);
		// map entity --> dto
		return mapper.map(addedUser, Userdto.class);
	}
	
	@Override
	public List<Userdto> getAllCustomer() {
		log.info("In User service implimentation : getAllCustomer ");
		
		List<User> userList=userRepository.findByUserRole(Role.ROLE_CUSTOMER);

		List<Userdto> userDtoList=new ArrayList<Userdto>();
		
		for(User uList:userList) {
			userDtoList.add(mapper.map(uList, Userdto.class));
		}
		return userDtoList;
	}

}
