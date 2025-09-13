package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dao.BuildingDao;
import com.laptrinhjavaweb.dao.RentAreaDao;
import com.laptrinhjavaweb.dao.anhyeuem.BuildingAnhyeuem;
import com.laptrinhjavaweb.dao.impl.BuildingDaoImpl;
import com.laptrinhjavaweb.dao.impl.RentAreaDaoImpl;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.input.BuildingSearchInput;
import com.laptrinhjavaweb.output.BuildingOutput;
import com.laptrinhjavaweb.service.BuildingService;

public class BuildingServiceImpl implements BuildingService {
	private BuildingConverter buildingConverter = new BuildingConverter();
	private RentAreaDao rentAreaDao = new RentAreaDaoImpl();

	private BuildingDao buildingDao = new BuildingDaoImpl();

	@Override
	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingModel) {

		List<BuildingOutput> buildingEmyeuanhs = new ArrayList<>();

		List<BuildingAnhyeuem> anhyeuems = buildingDao.findBuilding(
				buildingModel.getFloorArea(),
				buildingModel.getName(),
				buildingModel.getWard(),
				buildingModel.getStreet(),
				buildingModel.getDistrict(),
				buildingModel.getType());

		// int i = 0;
		for (BuildingAnhyeuem item : anhyeuems) {
			//anhyeuem -> buildingOutput
			BuildingOutput buildingOutput = buildingConverter.converFromAnhyeuemToOutput(item);
			
			buildingEmyeuanhs.add(buildingOutput);
		}
		return buildingEmyeuanhs;	
	}

	@Override
	public void save(BuildingDTO buildingDTO) {
		// TODO Auto-generated method stub
		if(buildingDTO.getId() == null) {
			//insert: dto -> anhyeuem
			BuildingAnhyeuem buildingAnhyeuem = buildingConverter.converFromDtoToAnhyeuem(buildingDTO);
			//Long buildingId = buildingDao.insert(buildingAnhyeuem);
			/*if(buildingDTO.getRentAreas().length() > 0) {
				for (String item: buildingDTO.getRentAreas().split(",")) {
					RentAreaAnhyeuem rentAreaAnhyeuem = new RentAreaAnhyeuem();
					rentAreaAnhyeuem.setValue(Integer.parseInt(item));
					rentAreaAnhyeuem.setBuildingId(buildingId);
					rentAreaDao.insert(rentAreaAnhyeuem);
										
				    }
			}*/
			
			buildingDao.insert(buildingAnhyeuem, buildingDTO.getRentAreas());
		}else {
			//update
		}
		
	}

}

