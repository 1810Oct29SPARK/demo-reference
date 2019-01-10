package com.revature.service;

import org.springframework.stereotype.Service;

@Service
public class Bear extends Animal {

	private Boolean bearFull = true; //bears eat before they hibernate
	private static Boolean isWinter = true;
	
	public Boolean getIsWinter(){
		return isWinter;
	}
	
	public void setIsWinter(Boolean isWinter){
		Bear.isWinter = isWinter;
	}

	@Override
	public void setFull(Boolean full) {
		this.bearFull = full;
	}

	@Override
	public Boolean isFull() {
		return this.bearFull;
	}

	@Override
	public void animalChasesYou() {
		System.out.println("Bear is chasing you");
	}
	
	public void bearHibernates() throws Exception {
		if (!Bear.isWinter) {
			throw new Exception("bears hibernate in the winter");
		}
		System.out.println("ZZZZZZZZZZZZZZ");
	}


}
