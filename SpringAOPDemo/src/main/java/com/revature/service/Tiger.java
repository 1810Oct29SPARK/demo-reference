package com.revature.service;

import org.springframework.stereotype.Component;

@Component
public class Tiger extends Animal {

	private Boolean tigerFull = false;

	@Override
	public Boolean isFull() {
		return this.tigerFull;
	}

	@Override
	public void setFull(Boolean full) {
		this.tigerFull = full;
	}

	@Override
	public void animalChasesYou() {
		System.out.println("Tiger is chasing you.");
	}

}
