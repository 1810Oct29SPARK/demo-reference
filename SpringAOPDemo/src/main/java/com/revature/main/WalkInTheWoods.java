package com.revature.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.service.Animal;
import com.revature.service.Bear;
import com.revature.service.Person;

public class WalkInTheWoods {

	public static void main(String[] args) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		Person p = (Person) ac.getBean("person");
		
		
		
		Bear a = (Bear) ac.getBean("bear");
		a.setSpeed(10);
		
		p.wakeUpAnimal();
		
		a.animalChasesYou();
		
		a.animalCatchesYou();
		
		a.setIsWinter(false);
		
		try {
			a.bearHibernates();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ac.close();
	}

}
