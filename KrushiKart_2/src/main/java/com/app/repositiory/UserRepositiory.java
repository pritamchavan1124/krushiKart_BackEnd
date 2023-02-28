package com.app.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Role;
import com.app.pojos.User;

public interface UserRepositiory extends JpaRepository<User,Long>{
	

	List<User> findByUserRole(Role roleCustomer);

}
