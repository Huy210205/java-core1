package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.output.BuildingOutput;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.utils.BuildingTypeUtils;

public class BuildingConverter {
	public BuildingOutput converFromEntityToOutput(BuildingEntity buildingEntity) {

		BuildingOutput result = new BuildingOutput();
		result.setName(buildingEntity.getName());
		result.setAddress(
				buildingEntity.getStreet() + " - " + buildingEntity.getWard() + "-" + buildingEntity.getDistrict());
		// Chuyển type code sang name
		result.setType(BuildingTypeUtils.getType(buildingEntity.getType()));
		return result;

	}

	public BuildingEntity converFromDtoToEntity(BuildingDTO buildingDTO) {
		BuildingEntity result = new BuildingEntity();
		result.setName(buildingDTO.getName());
		result.setStreet(buildingDTO.getStreet());

		return result;
	}

}
