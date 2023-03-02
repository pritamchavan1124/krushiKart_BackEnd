package com.app.dto;

import com.app.pojos.*;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

//@Setter
//@Getter
public class NewPasswordDto {

	@NotNull
	private String email;

	@NotNull
	private String newPassword;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
}
