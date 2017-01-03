package org.webwork.find.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("driver")
public class Driver {

	private License license;
	
	@Autowired
	public Driver(License license){
		this.license = license;
	}
	
	@Override
	public String toString(){
		return "Driver [license=" + license + "]";
	}
}
