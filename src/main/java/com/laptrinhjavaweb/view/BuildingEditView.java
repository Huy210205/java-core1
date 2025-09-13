package com.laptrinhjavaweb.view;

import com.laptrinhjavaweb.controller.BuildingController;
import com.laptrinhjavaweb.dto.BuildingDTO;

public class BuildingEditView {

	public static void main(String[] args) {
		String name = "tòa nhà 9";
		String street = "đường số 9";
		String ward = null;
		String district = null;
		Long floorArea = null;
		String rentAreas = "100";

		// set data cho new building
		BuildingDTO newBuilding = new BuildingDTO();
		newBuilding.setName(name);
		newBuilding.setStreet(street);
		newBuilding.setWard(ward);
		newBuilding.setDistrict(district);
		newBuilding.setFloorArea(floorArea);
		newBuilding.setRentAreas(rentAreas);

		// add building method
		BuildingController buildingController = new BuildingController();
		BuildingDTO result = buildingController.addBuilding(newBuilding);

		if (result != null) {
			System.out.println("Thêm tòa nhà thành công: " + result.getName());
		} else {
			System.out.println("Thêm tòa nhà KHÔNG thành công hoặc không có dữ liệu trả về!");
		}

	}

}
