package com.librarycatalog;
public class book {
	
	private String title;
	private String author;
	private String isbn;
}
public book(String title, String author, String isbn) {
	super();
	this.title = title;
	this.author = author;
	this.isbn = isbn;
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
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}

@Override

public String toString() {
	return "Title : "+title + ", Author :"+author+", ISBN : "+isbn;
}