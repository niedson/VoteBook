package com.niedson.votebook.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
	
	@Id @GeneratedValue
	private Long id;
	
	public Book() {}
	
	public Book(Long id, String name, String author, String image) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.image = image;
	}
	
	private String name, author, image;
	
	/* Getters and Setters */

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}