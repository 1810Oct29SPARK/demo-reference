package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Cave;
import com.revature.dao.CaveDAO;
import com.revature.dao.CaveDAOImpl;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		
		CaveDAO cd  = new CaveDAOImpl();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		funWithSessionMethods(sf);
		
	/*	List<Cave> caveList = cd.getAllCaves();
		for (Cave c : caveList) {
			System.out.println(c);
		}
		
		cd.addCave(new Cave("Rivendell", 200)); */
		
	}
	
	static void funWithSessionMethods(SessionFactory sf) {
		//create a session
		Session s = sf.getCurrentSession();
		Transaction tx = s.beginTransaction();
		
		//get and load
		Cave c1 = s.get(Cave.class, 33); //this will be null
		System.out.println(c1);
		
		//throws ObjectNotFoundException
		//Cave c2 = s.load(Cave.class, 35);
		//System.out.println(c2);
		
		Cave c3  = s.load(Cave.class, 1050);
		c3.getName();
		
		tx.commit();
		s.close();
		
		//throws a LazyInitializationException if it was not used inside the session
		System.out.println(c3);
	}

}
