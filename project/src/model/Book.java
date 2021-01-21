package model;

public class Book {
	int bookid;
	String title;
	String author;
	String publisher;
	int copies;
	
	public Book(){}

	public Book(int bookid, String title, String author, String publisher,
			int copies) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.copies = copies;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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
		return "Book [bookid=" + bookid + ", title=" + title + ", author="
				+ author + ", publisher=" + publisher + ", copies=" + copies
				+ "]";
	}
	
	
}
