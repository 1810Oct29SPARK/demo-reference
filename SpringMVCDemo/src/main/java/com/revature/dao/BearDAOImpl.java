package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.beans.Bear;

@Repository
@Transactional
@EnableTransactionManagement
public class BearDAOImpl implements BearDAO {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public BearDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Bear> allBears() {
		List<Bear> bears = new ArrayList<>();
		//use a Query to retrieve all bears
		try (Session s = sessionFactory.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			bears = s.createQuery("from Bear").getResultList();
			tx.commit();
			s.close();
		}
		return bears;
	}

	@Override
	public Bear getBearById(int id) {
		Bear b = null;
		try (Session s = sessionFactory.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			b = (Bear) s.get(Bear.class, id);
			tx.commit();
			//s.close();
		}
		return b;
	}

	@Override
	public void createBear(Bear bear) {
		try (Session s = sessionFactory.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(bear);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void updateBear(Bear bear) {
		try (Session s = sessionFactory.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.saveOrUpdate(bear);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void deleteBear(Bear bear) {
		try (Session s = sessionFactory.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(bear);
			tx.commit();
			s.close();
		}
	}

	

}
