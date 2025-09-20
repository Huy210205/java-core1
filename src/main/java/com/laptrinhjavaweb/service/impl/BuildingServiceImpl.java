package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.input.BuildingSearchInput;
import com.laptrinhjavaweb.output.BuildingOutput;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.repository.Impl.BuildingRepositoryImpl;
import com.laptrinhjavaweb.repository.Impl.RentAreaRepositoryImpl;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.service.BuildingService;

public class BuildingServiceImpl implements BuildingService {
	private BuildingConverter buildingConverter = new BuildingConverter();
	private RentAreaRepository rentAreaDao = new RentAreaRepositoryImpl();

	private BuildingRepository buildingDao = new BuildingRepositoryImpl();

	@Override
	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingModel) {

		List<BuildingOutput> buildingEmyeuanhs = new ArrayList<>();

		List<BuildingEntity> anhyeuems = buildingDao.findBuilding(
				buildingModel.getFloorArea(),
				buildingModel.getName(),
				buildingModel.getWard(),
				buildingModel.getStreet(),
				buildingModel.getDistrict(),
				buildingModel.getType());

		// int i = 0;
		for (BuildingEntity item : anhyeuems) {
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
			BuildingEntity buildingAnhyeuem = buildingConverter.converFromDtoToAnhyeuem(buildingDTO);
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

