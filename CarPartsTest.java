package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.component.CarPart;
import com.lti.component.CarPartsInventory;

public class CarPartsTest {

	@Test
	public void add() {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
		
		CarPartsInventory cp= (CarPartsInventory) context.getBean("carPartsImpl4");
		/*
		CarPart c= new CarPart();
		c.setPartNo(123);
		c.setPartName("Audio Player");
		c.setCarModel("Audi");
		c.setQuantity(60);
		
		cp.addNewPart(c);
		cp.getAvailableParts();
*/
		List<CarPart> list = cp.getAvailableParts();
		
		for(CarPart carPart : list) {
			System.out.println(carPart.getPartNo());
			System.out.println(carPart.getPartName());
			System.out.println(carPart.getCarModel());
			System.out.println(carPart.getQuantity());
			System.out.println("*********************************");
		}
	}
	
	

}
