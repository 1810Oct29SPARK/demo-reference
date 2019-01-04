package com.revature;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Bear;
import com.revature.beans.BearType;
import com.revature.beans.Beehive;
import com.revature.beans.Cave;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		//funWithSessionMethods(sf);
		/*List<Bear> bearList = funWithNamedQueries(sf);
		for (Bear b: bearList) {
			System.out.println(b.getBearType());//ok
			System.out.println(b.getCave());//not ok if Cave is lazily fetched
		}*/
		funWithMappings(sf);
		
	}
	
	static void funWithMappings(SessionFactory sf) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		//get list of bears of a certain type from BearType
		BearType bt = (BearType) s.get(BearType.class, 1);
		System.out.println(bt.getName());
		System.out.println(bt.getBears());
		
		Bear b = s.get(Bear.class, 12);
		
		for (Beehive bh : b.getBeehives()) {
			System.out.println(bh);
		}
		
		tx.commit();
		s.close();
	}
	
	static List<Bear> funWithNamedQueries(SessionFactory sf) {
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		/*
		Query q = s.getNamedQuery("getAllBears");
		List<Bear> bearList = q.getResultList();
		System.out.println(bearList.size());
		Iterator<Bear> it = bearList.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		*/
		
		Query q2 = s.createNamedQuery("getBearsByType",Bear.class);
		q2.setParameter("typeVar", 1); //looking for Grizzly bears
		List<Bear> grizzlies = q2.getResultList();
		
		tx.commit();
		s.close();
		return grizzlies;
		
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
		
		//save and persist
		//System.out.println(s.save(c3)); //get our generated id... but this was already persistent
		
		tx.commit();
		s.close();
		
		//throws a LazyInitializationException if it was not used inside the session
		System.out.println(c3);
		
		//create another session, c3 is still detached 
		Session s2 = sf.getCurrentSession();
		Transaction tx2 = s2.beginTransaction();
		
		//throws exception
		//s2.persist(c3);
		
		//s2.save(c3); //creates duplicate record with new PK 
		
		//update and merge
		
		Cave c4 = new Cave(1056, "USF", 300);
		s2.update(c4);
		
		//get a persistent cave
		Cave c5 = s2.get(Cave.class, 1); //in persistent state
		c5.setName("Norway"); //automatic dirty checking will update this at end of session
		
		//update entity that does not exist
		//s2.update(new Cave(33,"thirty three", 33));
		
		tx2.commit();
		s2.close();
	}

}
