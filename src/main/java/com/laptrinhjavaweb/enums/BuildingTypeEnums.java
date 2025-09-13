package com.laptrinhjavaweb.enums;

public enum BuildingTypeEnums {
	
	tang_tret ("tầng trệt"),  // calls constructor with value 3
	nguyen_can ("nguyên căn"), // calls constructor with value 2
	noi_that ("nội thất");
	
	private final String value;
	
	private BuildingTypeEnums(String value) {
		this.value = value;
		
	}

	public String getValue() {
		return value;
	}
	

}
