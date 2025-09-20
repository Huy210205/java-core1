package com.laptrinhjavaweb.repository.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.repository.entity.RentAreaEntity;
import com.laptrinhjavaweb.utils.ConnectionUtils;

public class RentAreaRepositoryImpl implements RentAreaRepository {

	@Override
	public void insert(RentAreaEntity areaAnhyeuem) {
		
		 try (Connection conn = ConnectionUtils.getConnection();
		         Statement stmt = conn.createStatement()) {

		        String sql = "INSERT INTO rentarea(value, buildingid) VALUES ("+areaAnhyeuem.getValue()+","+areaAnhyeuem.getBuildingId()+ ")";
		                     
		        stmt.executeUpdate(sql);

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		
	}

}
