package model;

public class Book {
	private int bid;
	private String title;
	private String publisher;
	private int copies;
	
	public Book() { }
	
	public Book(int id1, String title2, String author, int count) {
		// TODO Auto-generated constructor stub
		bid=id1;
		title=title2;
		publisher=author;
		copies=count;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getCopies() {
		return copies;
	}
	public void setCopies(int copies) {
		this.copies = copies;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", title=" + title + ", publisher="
				+ publisher + ", copies=" + copies + "]";
	}
	
	
}
