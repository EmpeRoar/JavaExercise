package model;

public enum EmploymentCategory {
	employed("employed"),
	selfEmployed("self employed"),
	unemployed("unemployed"),
	other("other");
	
	private String text;
	
	private EmploymentCategory(String text){
		this.text = text;
	}
	
	public String toString(){
		return text;
	}
	
	
}
