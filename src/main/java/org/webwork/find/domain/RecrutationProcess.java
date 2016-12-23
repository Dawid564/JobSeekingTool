package org.webwork.find.domain;

public class RecrutationProcess {
	
	String companyName;
	String companyDescription;
	
	
	public RecrutationProcess(){
		super();
	}
	
	public RecrutationProcess(String companyName, String companyDescription){
		super();
		this.companyDescription = companyDescription;
		this.companyName = companyName;
	}
	
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}
	
	public String getCompanyName(){
		return this.companyName;
	}
	
	public void setCompanyDescription(String companyDescription){
		this.companyDescription = companyDescription;
	}
	
	public String getCompanyDescription(){
		return this.companyDescription;
	}
}
