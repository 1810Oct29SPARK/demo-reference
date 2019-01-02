package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		
		//create a session
		try(SessionFactory sf = HibernateUtil.getSessionFactory()){
			Session s = sf.getCurrentSession();
			System.out.println(s.toString());
			s.close();
		}
		
	}

}
