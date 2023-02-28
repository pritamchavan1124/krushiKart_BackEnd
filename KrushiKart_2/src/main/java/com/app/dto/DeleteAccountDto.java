package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class DeleteAccountDto {

	private int userId;

	private String oldPassword;

	public DeleteAccountDto(int userId, String oldPassword) {
		super();
		this.userId = userId;
		this.oldPassword = oldPassword;
	}
	

	public DeleteAccountDto() {
		super();
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}


	@Override
	public String toString() {
		return "DeleteAccountDto [userId=" + userId + ", oldPassword=" + oldPassword + "]";
	}
	
}
