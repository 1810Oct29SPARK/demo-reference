package com.revature.vacation;

public class GoOnVacation {

	public static void main(String[] args) {
		System.out.println("let's go to Miami");
		System.out.println("we need a car");
		//using fully qualified classname of Car (package.classname)
		com.revature.transport.Car c = new com.revature.transport.Car();
		//or we could use imports.... save us typing!!!
		
		

	}

}
