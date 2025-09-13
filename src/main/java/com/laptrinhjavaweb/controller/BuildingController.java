package com.laptrinhjavaweb.controller;

import java.util.List;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.input.BuildingSearchInput;
import com.laptrinhjavaweb.output.BuildingOutput;
import com.laptrinhjavaweb.service.BuildingService;
import com.laptrinhjavaweb.service.impl.BuildingServiceImpl;

public class BuildingController {

	private BuildingService buildingService = new BuildingServiceImpl();

	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingSearch) {

		List<BuildingOutput> results = buildingService.findBuilding(buildingSearch);

		return results;
	}

	public BuildingDTO addBuilding(BuildingDTO newBuilding) {
		buildingService.save(newBuilding);
		return newBuilding;
	}
}
