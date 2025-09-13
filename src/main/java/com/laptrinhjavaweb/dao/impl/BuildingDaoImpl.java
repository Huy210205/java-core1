package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dao.BuildingDao;
import com.laptrinhjavaweb.dao.anhyeuem.BuildingAnhyeuem;
import com.laptrinhjavaweb.utils.ConnectionUtils;
import com.laptrinhjavaweb.utils.StringUtils;

public class BuildingDaoImpl implements BuildingDao {

	@Override
	public List<BuildingAnhyeuem> findBuilding(Integer floorArea, String name, String ward, String street,
			String district, String type) {
		List<BuildingAnhyeuem> results = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			StringBuilder sql = new StringBuilder("select * from building " + SystemConstant.ONE_EQUAL_ONE);

			if (floorArea != null) {
				sql.append(" and floorarea = " + floorArea);
			}
			if (!StringUtils.isNullOrEmpty(name)) {
				sql.append(" and name like '%" + name + "%'");
			}
			if (!StringUtils.isNullOrEmpty(ward)) {
				sql.append(" and ward like '%" + ward + "%'");
			}
			if (!StringUtils.isNullOrEmpty(street)) {
				sql.append(" and street like '%" + street + "%'");
			}
			if (!StringUtils.isNullOrEmpty(district)) {
				sql.append(" and district like '%" + district + "%'");
			}
			if (!StringUtils.isNullOrEmpty(type)) {
				sql.append(" and type like '%" + type + "%'");
			}

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = ConnectionUtils.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql.toString());

			while (rs.next()) {
				BuildingAnhyeuem buildingAnhyeuem = new BuildingAnhyeuem();
				buildingAnhyeuem.setName(rs.getString("name"));
				buildingAnhyeuem.setStreet(rs.getString("street"));
				buildingAnhyeuem.setWard(rs.getString("ward"));
				buildingAnhyeuem.setDistrict(rs.getString("district"));
				buildingAnhyeuem.setFloorArea(rs.getInt("floorarea"));
				buildingAnhyeuem.setType(rs.getString("type"));
				results.add(buildingAnhyeuem);
			}
			return results;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return new ArrayList<>();
	}

	@Override
	public Long insert(BuildingAnhyeuem buildingAnhyeuem, String rentAreas) {

		ResultSet resultSet = null;
		Long buildingId = null;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ConnectionUtils.getConnection();
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			String sql = "INSERT INTO building(name,street) VALUES ('" + buildingAnhyeuem.getName() + "','"
					+ buildingAnhyeuem.getStreet() + "')";

			int flag = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			resultSet = stmt.getGeneratedKeys();
			if (flag > 0) {
				while (resultSet.next()) {
					buildingId = resultSet.getLong(1);
				}

			}

			if (rentAreas.length() > 0) {
				for (String item : rentAreas.split(",")) {

					String sql2 = "INSERT INTO rentarea(value, buildingid) VALUES (" + Integer.parseInt(item) + ","
							+ buildingId + ")";
					stmt.executeUpdate(sql2);

				}
			}
			conn.commit();
			return buildingId;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				resultSet.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
}
