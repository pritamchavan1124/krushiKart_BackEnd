package com.app.service.user;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.DeleteAccountDto;
import com.app.dto.Userdto;
import com.app.pojos.Address;

public interface IUserService {

	Userdto saveNewUser(@Valid Userdto userObj);

	List<Userdto> getAllCustomer();

	Userdto updateExistingUser(Userdto updateUser);

	String deleteUserDetails(DeleteAccountDto account);

	Userdto getUserByEmail(String userEmail);

	Userdto getUserById(int userId);

	

	

}
