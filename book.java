package library_management;

import java.io.Serializable;

public class Book implements Serializable {
	private int isbn;
	private String author;
	private String title;
	private String publisher;
	private int edition;
	private String subject;
	private int available_quantity;
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getAvailable_quantity() {
		return available_quantity;
	}
	public void setAvailable_quantity(int available_quantity) {
		this.available_quantity = available_quantity;
	}
	public Book(int isbn, String author, String title, String publisher, int edition, String subject,
			int available_quantity) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.publisher = publisher;
		this.edition = edition;
		this.subject = subject;
		this.available_quantity = available_quantity;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", author=" + author + ", title=" + title + ", publisher=" + publisher
				+ ", edition=" + edition + ", subject=" + subject + ", available_quantity=" + available_quantity + "]";
	}
	
}