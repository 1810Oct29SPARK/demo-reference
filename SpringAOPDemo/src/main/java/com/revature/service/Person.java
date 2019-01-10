package com.revature.service;

import org.springframework.stereotype.Component;

@Component
public class Person {

	public static int maxHumanSpeed = 15;

	public static int getSpeed() {
		return Person.maxHumanSpeed;
	}

	public void wakeUpAnimal() {
		System.out.println("Woke up animal.");
	}

}
