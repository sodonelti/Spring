package com.lti.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.component.Calculator;
import com.lti.component.CurrencyConverter;
import com.lti.component.HelloWorld;

public class HelloTest {

	public static void main(String[] args) {
		//loading Spring's IoC container
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		//accessing one of the bean
		HelloWorld hw= (HelloWorld) context.getBean("hw"); //bean id
		System.out.println(hw.sayHello("Shreena"));
		
		
		Calculator cc=(Calculator) context.getBean("cal");
		System.out.println(cc.add(15,15));
		System.out.println(cc.sub(15, 15));
		
		CurrencyConverter conv=(CurrencyConverter) context.getBean("cc");
		System.out.println(conv.convertDollarToRupees(50));
	}
}
