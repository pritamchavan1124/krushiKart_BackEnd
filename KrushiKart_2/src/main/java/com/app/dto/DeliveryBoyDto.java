package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import com.app.pojos.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeliveryBoyDto {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;

	@NotBlank
	@Email(message = "Invalid Email,please Enter valid email!!")
	private String email;

	@NotEmpty(message = "First name must be supplied")
	@Length(min = 4, max = 30, message = "Invalid First name length")
	private String firstName;

	@NotBlank(message = "Last name must be supplied")
	private String lastName;

	@JsonProperty(access = Access.WRITE_ONLY) // for de-serial only
	private String password;

	@Past(message = "Date of birth  must not be future")
	private LocalDate DOB;

	@Digits(message = "Number should contain 10 digits.", fraction = 0, integer = 10)
	private String contactNumber;

	@NotNull
	private Role userRole;

	private String city;

	private String state;
	
	private String licenseNO;
	//private String imagePath;


}
