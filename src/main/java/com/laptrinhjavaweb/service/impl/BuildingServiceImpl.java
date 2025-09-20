package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.input.BuildingSearchInput;
import com.laptrinhjavaweb.output.BuildingOutput;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.impl.BuildingRepositoryImpl;
import com.laptrinhjavaweb.repository.impl.RentAreaRepositoryImpl;
import com.laptrinhjavaweb.service.BuildingService;

public class BuildingServiceImpl implements BuildingService {
	private BuildingConverter buildingConverter = new BuildingConverter();
	private RentAreaRepository rentAreaRepository = new RentAreaRepositoryImpl();

	private BuildingRepository buildingRepository = new BuildingRepositoryImpl();

	@Override
	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingModel) {

		List<BuildingOutput> buildingEmyeuanhs = new ArrayList<>();

		List<BuildingEntity> buildingEntities = buildingRepository.findBuilding(
				buildingModel.getFloorArea(),
				buildingModel.getName(),
				buildingModel.getWard(),
				buildingModel.getStreet(),
				buildingModel.getDistrict(),
				buildingModel.getType());

		// int i = 0;
		for (BuildingEntity item : buildingEntities) {
			// entity -> buildingOutput
			BuildingOutput buildingOutput = buildingConverter.converFromEntityToOutput(item);

			buildingEmyeuanhs.add(buildingOutput);
		}
		return buildingEmyeuanhs;
	}

	@Override
	public void save(BuildingDTO buildingDTO) {
		// TODO Auto-generated method stub
		if (buildingDTO.getId() == null) {
			// insert: dto -> entity
			BuildingEntity buildingEntity = buildingConverter.converFromDtoToEntity(buildingDTO);
			// Long buildingId = buildingRepository.insert(buildingEntity);
			/*
			 * if(buildingDTO.getRentAreas().length() > 0) {
			 * for (String item: buildingDTO.getRentAreas().split(",")) {
			 * RentAreaEntity rentAreaEntity = new RentAreaEntity();
			 * rentAreaEntity.setValue(Integer.parseInt(item));
			 * rentAreaEntity.setBuildingId(buildingId);
			 * rentAreaRepository.insert(rentAreaEntity);
			 * 
			 * }
			 * }
			 */

			buildingRepository.insert(buildingEntity, buildingDTO.getRentAreas());
		} else {
			// update
		}

	}

}
