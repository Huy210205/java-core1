package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.laptrinhjavaweb.dao.RentAreaDao;
import com.laptrinhjavaweb.dao.anhyeuem.RentAreaAnhyeuem;
import com.laptrinhjavaweb.utils.ConnectionUtils;

public class RentAreaDaoImpl implements RentAreaDao {

	@Override
	public void insert(RentAreaAnhyeuem areaAnhyeuem) {
		
		 try (Connection conn = ConnectionUtils.getConnection();
		         Statement stmt = conn.createStatement()) {

		        String sql = "INSERT INTO rentarea(value, buildingid) VALUES ("+areaAnhyeuem.getValue()+","+areaAnhyeuem.getBuildingId()+ ")";
		                     
		        stmt.executeUpdate(sql);

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		
	}

}
