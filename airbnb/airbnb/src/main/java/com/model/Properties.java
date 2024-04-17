package com.model;

public class Properties {
	private int propertyId;
	private int userId;
	private String propertyTitle;
	private String propertyLocation;
	private String propertyCity;
	private float propertyPrice;
	private String propertyDescription;
	private String propertyImage;
	private String propertyType;
	
	public Properties() {
		
	}

	

	public Properties(int propertyId, int userId, String propertyTitle, String propertyLocation, String propertyCity,
			float propertyPrice, String propertyDescription, String propertyImage, String propertyType) {
		super();
		this.propertyId = propertyId;
		this.userId = userId;
		this.propertyTitle = propertyTitle;
		this.propertyLocation = propertyLocation;
		this.propertyCity = propertyCity;
		this.propertyPrice = propertyPrice;
		this.propertyDescription = propertyDescription;
		this.propertyImage = propertyImage;
		this.propertyType = propertyType;
	}

	

	

	public Properties(int userId, String propertyTitle, String propertyLocation, String propertyCity,
			float propertyPrice, String propertyDescription, String propertyImage, String propertyType) {
		super();
		this.userId = userId;
		this.propertyTitle = propertyTitle;
		this.propertyLocation = propertyLocation;
		this.propertyCity = propertyCity;
		this.propertyPrice = propertyPrice;
		this.propertyDescription = propertyDescription;
		this.propertyImage = propertyImage;
		this.propertyType = propertyType;
	}



	public Properties(String propertyTitle, String propertyLocation, String propertyCity, float propertyPrice,
			String propertyDescription, String propertyImage, String propertyType) {
		super();
		this.propertyTitle = propertyTitle;
		this.propertyLocation = propertyLocation;
		this.propertyCity = propertyCity;
		this.propertyPrice = propertyPrice;
		this.propertyDescription = propertyDescription;
		this.propertyImage = propertyImage;
		this.propertyType = propertyType;
	}



	public int getPropertyId() {
		return propertyId;
	}



	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getPropertyTitle() {
		return propertyTitle;
	}



	public void setPropertyTitle(String propertyTitle) {
		this.propertyTitle = propertyTitle;
	}



	public String getPropertyLocation() {
		return propertyLocation;
	}



	public void setPropertyLocation(String propertyLocation) {
		this.propertyLocation = propertyLocation;
	}



	public String getPropertyCity() {
		return propertyCity;
	}



	public void setPropertyCity(String propertyCity) {
		this.propertyCity = propertyCity;
	}



	public float getPropertyPrice() {
		return propertyPrice;
	}



	public void setPropertyPrice(float propertyPrice) {
		this.propertyPrice = propertyPrice;
	}



	public String getPropertyDescription() {
		return propertyDescription;
	}



	public void setPropertyDescription(String propertyDescription) {
		this.propertyDescription = propertyDescription;
	}



	public String getpropertyImage() {
		return propertyImage;
	}



	public void setpropertyImage(String imageUrl) {
		this.propertyImage = imageUrl;
	}



	public String getPropertyType() {
		return propertyType;
	}



	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}



	@Override
	public String toString() {
		return "Properties [propertyId=" + propertyId + ", userId=" + userId + ", propertyTitle=" + propertyTitle
				+ ", propertyLocation=" + propertyLocation + ", propertyCity=" + propertyCity + ", propertyPrice="
				+ propertyPrice + ", propertyDescription=" + propertyDescription + ", propertyImage=" + propertyImage
				+ ", propertyType=" + propertyType + "]";
	}



	

	
	

	
}
