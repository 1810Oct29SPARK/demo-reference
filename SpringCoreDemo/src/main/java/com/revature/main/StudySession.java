package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Author;

public class StudySession {

	public static void main(String[] args) {

		// access IoC container
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		funWithAuthors(ac);

		// close ApplicationContext
		((AbstractApplicationContext) ac).close();

	}

	static void funWithAuthors(ApplicationContext ac) {
		// throws NoSuchBeanDefinitionException if name provided does not match anything
		// in IoC container
		Author a1 = (Author) ac.getBean("author");
		Author a2 = (Author) ac.getBean("author");
		// default scope of a Spring bean is SINGLETON
		// one instance per application context
		System.out.println("a1 and a2 are the same object: " + (a1 == a2));
	}

}
