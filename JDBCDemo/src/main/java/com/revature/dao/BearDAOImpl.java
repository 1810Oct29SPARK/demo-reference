package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Bear;
import com.revature.util.ConnectionUtil;

public class BearDAOImpl implements BearDAO {
	
	private static final String filename = "connection.properties";

	@Override
	public List<Bear> getBears() {
		List<Bear> bl = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnection(filename)){
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bl;
	}

	@Override
	public Bear getBearById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
