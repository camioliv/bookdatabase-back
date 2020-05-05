package com.books.apirest.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@IdClass(RatingId.class)
@Table(name="users_books")
public class Rating implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id	
	@ManyToOne
	@JoinColumn(name="book_id")
	@JsonBackReference(value="ratingBook")
	private Book book;

	@Id
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonBackReference(value="ratingUser")
	private User user;
	
	private int stars;
		
	public Rating() {

	}	

	public Rating(Book book, User user, int stars) {
		this.book = book;
		this.user = user;
		this.stars = stars;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}	
	

}
