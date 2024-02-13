package dao;

public class User_data {
	
	
	private String name;
	private String address;
	private String password;
	private int age;
	private int custid;
	
	
	
	public User_data( String name, String address, String password, int age, int custid) {
		super();
		
		this.name = name;
		this.address = address;
		this.password = password;
		this.age = age;
		this.custid = custid;
	}
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}

	
	
}
