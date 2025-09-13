package com.laptrinhjavaweb.view;

import java.util.List;

import com.laptrinhjavaweb.controller.BuildingController;
import com.laptrinhjavaweb.input.BuildingSearchInput;
import com.laptrinhjavaweb.output.BuildingOutput;

public class BuildingListView {

	public static void main(String[] args) {

		Integer floorArea = null;
		String name = null;
		String ward = null;
		String street = null;
		String district = null;
		String type = "tang_tret";

		BuildingSearchInput buildingSearch = new BuildingSearchInput();
		buildingSearch.setFloorArea(floorArea);

		buildingSearch.setDistrict(district);
		buildingSearch.setName(name);
		buildingSearch.setStreet(street);
		buildingSearch.setWard(ward);
		buildingSearch.setType(type);
		BuildingController buildingController = new BuildingController();

		List<BuildingOutput> buildings = buildingController.findBuilding(buildingSearch);
		if (buildings != null) {
			for (BuildingOutput item : buildings) {
				System.out.println(
						"Name:" + item.getName() + "; Address:" + item.getAddress() + "; Type:" + item.getType());
			}

		}
		// System.out.println("test");

	}
}
