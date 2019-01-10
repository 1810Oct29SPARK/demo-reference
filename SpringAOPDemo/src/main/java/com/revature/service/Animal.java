package com.revature.service;

public abstract class Animal {
	
	protected int speed;
	
	// is the animal hungry?
	public abstract Boolean isFull();

	public abstract void setFull(Boolean full);

	// what happens if you upset the animal
	public abstract void animalChasesYou();

	public void animalCatchesYou() {
		System.out.println("Hope it's not hungry.");
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
