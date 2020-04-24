package com.cg.hcs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.ManyToOne;
@Entity
@Table(name="users")
public class Users 
{
	@Id
	@Column(name = "user_id")
	private String user_id;
	@Column(name = "user_name")
	private String user_name;
	@Column(name = "password")
	private String password;
	@Column(name = "phone_no")
	private Long phone_no;
	@Column(name = "role")
	private final static String role = "user";
	
	public Users() {}
	
	public Users(String user_id, String user_name, String password, Long phone_no) 
	{
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.phone_no = phone_no;
	}
	public String getUser_id() 
	{
		return user_id;
	}
	public void setUser_id(String user_id) 
	{
		this.user_id = user_id;
	}
	public String getUser_name() 
	{
		return user_name;
	}
	public void setUser_name(String user_name) 
	{
		this.user_name = user_name;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public Long getPhone_no() 
	{
		return phone_no;
	}
	public void setPhone_no(Long phone_no) 
	{
		this.phone_no = phone_no;
	}
	public String getRole() 
	{
		return role;
	}
}
