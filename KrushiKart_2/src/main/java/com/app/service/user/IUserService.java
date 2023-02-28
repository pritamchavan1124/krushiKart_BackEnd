package com.app.service.user;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.Userdto;

public interface IUserService {

	Userdto saveNewUser(@Valid Userdto userObj);

	List<Userdto> getAllCustomer();

}
