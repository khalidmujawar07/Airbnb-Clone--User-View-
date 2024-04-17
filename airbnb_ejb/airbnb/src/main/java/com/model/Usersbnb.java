package com.model;

public class Usersbnb {
	private int userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private String userAddress;
	private String userMobile;
	private String userAvatar;
	
	public Usersbnb() {
	
	}

	public Usersbnb(int userId, String userName, String userEmail, String userPassword, String userAddress,
			String userMobile, String userAvatar ) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
		this.userMobile = userMobile;
		this.userAvatar = userAvatar;
	}
	
	

	
	
	
	
	
	public Usersbnb(int userId, String userName, String userEmail, String userAddress, String userMobile,
			String userAvatar) {
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userMobile = userMobile;
		this.userAvatar = userAvatar;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	
	

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	@Override
	public String toString() {
		return "Usersbnb [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userAddress=" + userAddress + ", userMobile=" + userMobile + ", userAvatar="
				+ userAvatar + "]";
	}

	
	
	
}
