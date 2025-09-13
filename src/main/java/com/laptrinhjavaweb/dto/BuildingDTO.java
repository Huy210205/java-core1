package com.laptrinhjavaweb.dto;

public class BuildingDTO extends BaseDTO {

	
	
	private Long id;
	private String name;
	private String address;
	private String ward;
	private String street;
	private String district;
	private Long floorArea;
	private String rentAreas;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public Long getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(Long floorArea) {
		this.floorArea = floorArea;
	}
	public String getRentAreas() {
		return rentAreas;
	}
	public void setRentAreas(String rentAreas) {
		this.rentAreas = rentAreas;
	}
	
	
}
