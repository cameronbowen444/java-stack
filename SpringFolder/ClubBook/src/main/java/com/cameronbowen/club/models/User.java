package com.cameronbowen.club.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Name must be non-empty")
	@Size(min=3, max=30, message="Name must be between 3 and 30 characters!")
	private String userName;
	
	@NotEmpty(message="email must be non-empty")
	@Email(message="Please Enter a Valid email format")
	private String email;
	
	@NotEmpty(message="password must be non-empty")
	@Size(min=8, max=128, message="Password must be between 8 and 128 characters!")
	private String password;
	
	@Transient
	@NotEmpty(message="please confirm your password!")
	@Size(min=8, max=128, message="Passwords do not match!")
	private String confirm;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@Column(updatable=false)
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<Book> books;
	
	@Column(updatable=false)
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<Book> borrowedBooks;
	
	
	public User() {
	}


	public User(String userName, String email, String password, String confirm, Date createdAt, Date updatedAt, List<Book> books, List<Book> borrowedBooks) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.confirm = confirm;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.books = books;
		this.borrowedBooks = borrowedBooks;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirm() {
		return confirm;
	}


	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}


	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}


	public void setBorrowedBooks(List<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}
	
	
	
	
	
}
