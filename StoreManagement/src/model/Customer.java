package src.model;

public class Customer extends Person {
	private boolean isVIP;
	private int Point;

	public Customer(){

	}

	public Customer(String ID, String name, String DoB, String address, String phone, boolean isVIP, int Point) {
		super(ID, name, DoB, address, phone);
		this.isVIP = isVIP;
		this.Point = Point;
	}

	public boolean isVIP() {
		return isVIP;
	}

	public void setVIP(boolean isVIP) {
		this.isVIP = isVIP;
	}

	public int getPoint() {
		return Point;
	}

	public void setPoint(int point) {
		Point = point;
	}
	
	

}
