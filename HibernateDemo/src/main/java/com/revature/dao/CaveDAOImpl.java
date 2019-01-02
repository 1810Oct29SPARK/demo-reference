package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Cave;
import com.revature.util.HibernateUtil;

public class CaveDAOImpl implements CaveDAO {

	@Override
	public Cave getCaveById(int id) {
		Cave c = null;
		try (SessionFactory sf = HibernateUtil.getSessionFactory()) {
			Session s = sf.getCurrentSession();
			Transaction tx = s.beginTransaction();
			c = (Cave) s.get(Cave.class, id);
			tx.commit();
			s.close();
		}
		return c;
	}

	@Override
	public List<Cave> getAllCaves() {
		List<Cave> caves = new ArrayList<>();
		//use a Query to retrieve all caves
		try (SessionFactory sf = HibernateUtil.getSessionFactory()) {
			Session s = sf.getCurrentSession();
			Transaction tx = s.beginTransaction();
			caves = s.createQuery("from Cave").getResultList();
			tx.commit();
			s.close();
		}
		return caves;
	}

	@Override
	public void addCave(Cave cave) {
		try (SessionFactory sf = HibernateUtil.getSessionFactory()) {
			Session s = sf.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.persist(cave);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void updateCave(Cave cave) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCave(Cave cave) {
		// TODO Auto-generated method stub

	}

}
