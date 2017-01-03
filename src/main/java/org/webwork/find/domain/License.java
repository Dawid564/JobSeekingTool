package org.webwork.find.domain;

import org.springframework.stereotype.Component;

@Component
public class License {
	private String number = "1234567890";
	
	@Override 
	public String toString(){
		return "License [Number= " + number + "]";
	}
	
	public void setNumber(String number){
		this.number = number;
	}
	
	public String getNumber(){
		return this.number;
	}
}
