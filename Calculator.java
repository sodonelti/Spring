package com.lti.component;

import org.springframework.stereotype.Component;

@Component("cal")
public class Calculator {

	public int add(int x,int y) {
		return x+y;
	}
	
	public int sub(int x,int y) {
		return x-y;
	}
}
