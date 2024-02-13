package dao;

public class Allbookdata {

	private int bookid;
	private String bookname;
	private int price;
	private int quantity;
	
	
		public Allbookdata(int bookid, String bookname, int price, int quantity) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.price = price;
		this.quantity = quantity;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
