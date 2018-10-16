package hh.swd2.ekaSpringProjekti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Book {
    @Id
  //  @GeneratedValue(strategy=GenerationType.AUTO)
    // @column name="etunimi"
    private Long isbn;
    private String title;
    private String author;
    private String year;
    private double price;

    public Book() {}

	public Book(Long isbn, String author, String title, String year, double price) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		
		this.year=year;
		this.price=price;
	}
	
/*	@Override
	public String toString() {
		return "title=" + title + ", author=" + author + ", isbn=" + id + ", year=" + year + ", price=" + price
				;
	}*/
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ",author=" + author + ", title=" + title + ", year=" + year + ", price=" + price + "]";
	}
	public String getTitle() { 	return title;}
	
	public void setTitle(String title) {	this.title = title;}
	
	public String getAuthor() {	return author;}
	
	public void setAuthor(String author) {	this.author = author;}
	
	public Long getIsbn() {	return isbn;}
	
	public void setIsbn(Long isbn) {	this.isbn = isbn;}
	
	public String getYear() {	return year;}
	
	public void setYear(String year) {	this.year = year;}
	
	public double getPrice() {	return price;}
	
	public void setPrice(double price) {	this.price = price;}
}
