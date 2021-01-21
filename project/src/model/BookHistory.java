package model;

import java.time.LocalDate;

public class BookHistory {
	Book b= new Book();
	String i,r,u;
	
	public BookHistory(){
		
	}
	
	public BookHistory(Book b,String u,String i,String r)
	{
		this.b=b;
		this.u=u;
		this.i=i;
		this.r=r;
	}
	
	

	public Book getB() {
		return b;
	}

	public void setB(Book b) {
		this.b = b;
	}

	public String getI() {
		return i;
	}

	public void setU(String u) {
		this.u = u;
	}
	
	public String getU() {
		return u;
	}

	public void setI(String i) {
		this.i = i;
	}

	public String getR() {
		return r;
	}

	public void setR(String r) {
		this.r = r;
	}

	@Override
	public String toString() {
		return "BookHistory [book=" + b.toString() + ", issuedate=" + i + ", returndate=" + r + "]";
	}
	
	
}
