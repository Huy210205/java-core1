package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dao.anhyeuem.BuildingAnhyeuem;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.output.BuildingOutput;
import com.laptrinhjavaweb.utils.BuildingTypeUtils;

public class BuildingConverter {
	public BuildingOutput converFromAnhyeuemToOutput(BuildingAnhyeuem buildingAnhyeuem) {
		
		BuildingOutput result = new BuildingOutput();
		result.setName(buildingAnhyeuem.getName());
		result.setAddress(buildingAnhyeuem.getStreet() + " - " + buildingAnhyeuem.getWard() + "-" + buildingAnhyeuem.getDistrict());
		// Chuyển type code sang name
		result.setType(BuildingTypeUtils.getType(buildingAnhyeuem.getType()));
		return result;
		
	}
	public BuildingAnhyeuem converFromDtoToAnhyeuem(BuildingDTO buildingDTO) {
		BuildingAnhyeuem result = new BuildingAnhyeuem();
		result.setName(buildingDTO.getName());
		result.setStreet(buildingDTO.getStreet());
		
	return result;
	}
	
	
	

}
