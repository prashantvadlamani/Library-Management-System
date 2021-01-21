package models;

public class Books {
	  int bid;
	  String title;
	 String publisher;
	int copies;
	public Books(int a,String b,String c,int d)
	{
		bid=a;
		title=b;
		publisher=c;
		copies=d;
	}
	@Override
	public String toString() {
		return "Books [bid=" + bid + ", title=" + title + ", publisher="
				+ publisher + ", copies=" + copies + "]";
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
	
	
	
}
