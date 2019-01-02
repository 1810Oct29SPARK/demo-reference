package com.revature;

import java.util.List;

import com.revature.beans.Cave;
import com.revature.dao.CaveDAO;
import com.revature.dao.CaveDAOImpl;

public class Driver {

	public static void main(String[] args) {
		
		CaveDAO cd  = new CaveDAOImpl();
		List<Cave> caveList = cd.getAllCaves();
		for (Cave c : caveList) {
			System.out.println(c);
		}
		
	}

}
