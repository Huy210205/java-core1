package com.laptrinhjavaweb.repository;

import java.util.List;

import com.laptrinhjavaweb.repository.entity.BuildingEntity;

public interface BuildingRepository {

	List<BuildingEntity> findBuilding(Integer floorArea, String name, String ward, String street, String district,
			String type);
	
	Long insert(BuildingEntity buildingAnhyeuem, String rentAreas);
}
