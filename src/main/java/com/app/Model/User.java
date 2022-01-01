package com.app.Model;

import javax.persistence.*;

@Entity
@Table(name =  "user_details", uniqueConstraints={@UniqueConstraint(columnNames={"username"})})
public class User 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="firstName")
	private String fName;

	@Column(name="lName")
	private String lName;
	
	@Column(name="Email")
	private String email;

	@Column(name="Mobile", nullable = false, unique = true)
	private long mobile;
	
	@Column(unique=true)
	private String username;

	@Column()
	private String password;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
