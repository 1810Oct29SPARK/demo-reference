package com.revature.dao;

import java.util.List;

import com.revature.beans.Bear;

public interface BearDAO {
	
	public List<Bear> allBears();
	public Bear getBearById(int id);
	public void createBear(Bear bear);
	public void updateBear(Bear bear);
	public void deleteBear(Bear bear);

}
