package com.cameronbowen.myexam.models;

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

import org.springframework.format.annotation.DateTimeFormat;





@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Name is required!")
	@Size(min=3, message="Name must be at least 3 characters!")
	private String name;
	
	@NotEmpty(message="Email is required!")
	@Email(message="Username must be at least 3 characters!")
	private String email;
	
	@NotEmpty(message="Password is required!")
	@Size(min=8, max=128, message="Pasword must be between 8 and 128 characters!")
	private String password;
	
	@Transient
	@NotEmpty(message="Please confirm your password!")
	@Size(min=8, max=128, message="Confirm pasword must be between 8 and 128 characters!")
	private String confirm;
	
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<Show> shows;




	public User() {
	}

	public User(String name, String email, String password, String confirm,
			Date createdAt, Date updatedAt, List<Show> shows) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirm = confirm;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.shows = shows;
	}

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
	public List<Show> getShows() {
		return shows;
	}
	public void setShows(List<Show> shows) {
		this.shows = shows;
	}

	
	
	
	
	
	
	
	
	
}
