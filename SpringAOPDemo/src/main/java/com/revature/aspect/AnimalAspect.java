package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.revature.service.Animal;
import com.revature.service.Person;

@Aspect
@Component
public class AnimalAspect {

	@AfterReturning("execution(* wake*(..))")
	public void afteWakeAnimal(JoinPoint jp) {
		System.out.println("that was not a good choice");
		System.out.println(jp.getSignature());
	}
	
	//can it actually catch you? 
	@Around("execution(* *CatchesYou(..))")
	public void afterCatchesYou(ProceedingJoinPoint pjp) throws Throwable {
		int personSpeed = Person.maxHumanSpeed;
		Animal a = (Animal) pjp.getTarget();
		if (personSpeed <= a.getSpeed()) {
			//animal caught you
			System.out.println("too slow");
			pjp.proceed(); //when method actually executes
			//check whether animal is hungry
			if (!a.isFull()) {
				System.out.println("you are lunch");
				a.setFull(true);
			} else {
				System.out.println("you got lucky");
			}
		} else {
			System.out.println("you got away!");
		}
		
	}

}
