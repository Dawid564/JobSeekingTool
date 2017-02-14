package org.webwork.find.domain;

public class ChangePassword {
	
	private String freshPassword;
	
	private String oldPassword;
	
	public ChangePassword(){}

	public String getFreshPassword() {
		return freshPassword;
	}

	public void setFreshPassword(String freshPassword) {
		this.freshPassword = freshPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

}
