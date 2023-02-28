package com.app.service.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import com.app.custom_Exceptions.UserHandlingException;
import com.app.dto.DeleteAccountDto;
import com.app.dto.Userdto;
import com.app.pojos.Address;
import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.repositiory.AddressRepository;
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
	@Autowired
	private AddressRepository addressRepo;
	@Override
	public Userdto saveNewUser(Userdto userObj) {
	
		log.info("In user service implimentation : Save user ");
		// map dto --> entity
		Address address = userObj.getAddress();
		addressRepo.save(address);
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
	//add method for update the new user
	@Override
	public Userdto updateExistingUser(Userdto updateUser) {
		
		log.info("In user service implimentation : update user ById ");
		
		Optional<User> user = userRepository.findByEmail(updateUser.getEmail());
		if(user.get() != null) {
			user.get().setEmail(updateUser.getEmail());
			user.get().setFirstName(updateUser.getFirstName());
			user.get().setLastName(updateUser.getLastName());
			user.get().setContactNumber(updateUser.getContactNumber());
			user.get().setDOB(updateUser.getDOB());
			user.get().setUserRole(updateUser.getUserRole());
			User persistance=userRepository.save(user.get());
			return mapper.map(persistance, Userdto.class);
//			 User updatedUser = mapper.map(updateUser, User.class);
//			 userRepository.save(updatedUser);
			 
		}else
		{
			throw new UserHandlingException("Invalid Email id");
		}
		
	}

	@Override
	public String deleteUserDetails(DeleteAccountDto account) {
		log.info("In user service implimentation : delete user ById ");
		String mesg = "Deletion of user details failed!!!!!!!!!!!";
		User findUser = userRepository.findById(account.getUserId())
				.orElseThrow(() -> new UserHandlingException("Invalid user ID"));
//		if (encoder.matches(account.getOldPassword(), findUser.getPassword())) {
//			cartService.deleteByUser(findUser.getId());
//			userRepository.deleteById(findUser.getId());
//			mesg = "user details deleted successfully , for User id :" + findUser.getId();
//		}
		return mesg;

	}
}
