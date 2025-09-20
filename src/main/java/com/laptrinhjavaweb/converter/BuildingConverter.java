package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.output.BuildingOutput;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.utils.BuildingTypeUtils;

public class BuildingConverter {
	public BuildingOutput converFromAnhyeuemToOutput(BuildingEntity buildingAnhyeuem) {
		
		BuildingOutput result = new BuildingOutput();
		result.setName(buildingAnhyeuem.getName());
		result.setAddress(buildingAnhyeuem.getStreet() + " - " + buildingAnhyeuem.getWard() + "-" + buildingAnhyeuem.getDistrict());
		// Chuyển type code sang name
		result.setType(BuildingTypeUtils.getType(buildingAnhyeuem.getType()));
		return result;
		
	}
	public BuildingEntity converFromDtoToAnhyeuem(BuildingDTO buildingDTO) {
		BuildingEntity result = new BuildingEntity();
		result.setName(buildingDTO.getName());
		result.setStreet(buildingDTO.getStreet());
		
	return result;
	}
	
	
	

}
