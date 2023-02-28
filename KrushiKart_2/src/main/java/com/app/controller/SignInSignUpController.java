
package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.SellerDto;
import com.app.dto.Userdto;
import com.app.service.Supplier.ISupplierService;
import com.app.service.user.IUserService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
@Slf4j
public class SignInSignUpController {
	
	//user services dependency injected
	@Autowired
	private IUserService userServices;
	
	@Autowired
	private ISupplierService sellerServices;
	
	@PostMapping("/user/signin")
	public ResponseEntity<?> userRegistration(@RequestBody @Valid Userdto userObj,BindingResult bindingRelt){
		
		// invoke service layer method
		
		 return ResponseEntity.status(HttpStatus.CREATED).body(userServices.saveNewUser(userObj));
		
	}
	
	@PostMapping("/seller/signin")
	public ResponseEntity<?> sellerRegistration(@RequestBody @Valid SellerDto sellerobj,BindingResult br){
		if(br.hasErrors()) {
			return  ResponseEntity.badRequest().body(br.getAllErrors());// :
		}
		// invoke service layer method , for saving : user info + associated roles info
		return ResponseEntity.status(HttpStatus.CREATED).body(sellerServices.saveSupplier(sellerobj));
	}

}
