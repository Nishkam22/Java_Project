package dao;

public class Searchdata {
	
	
	private int bookid;
	private String bookname;
	private int price;
	
	
	
	public Searchdata(int bookid, String bookname, int price) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.price = price;
	}
	
	
	
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
		
	
}
