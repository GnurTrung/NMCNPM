package src.model;


public class Person {
	private String ID;
	private String name;
	private String DoB;
	private String address;
	private String phone;

	public Person(){

	}
	
	public Person(String ID, String name, String DoB, String address, String phone) {
		this.ID = ID;
		this.name = name;
		this.DoB = DoB;
		this.address = address;
		this.phone = phone;
		
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getDoB() {
		return DoB;
	}
	
	
	public void setDoB(String doB) {
		DoB = doB;
	}
	
	
	public String getAddress() {
		return address;
	}
	
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getPhone() {
		return phone;
	}
	
	
	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}
}
