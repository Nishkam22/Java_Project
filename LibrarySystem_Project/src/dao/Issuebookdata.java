package dao;

public class Issuebookdata {

	
	private String bookname;
	private int custid;
	
	
	
	
	public Issuebookdata(String bookname, int custid) {
		super();
		this.bookname = bookname;
		this.custid = custid;
	}
	
	
	
	
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	
	
	
}
