package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Table(name = "user")
public class User {
	
	@Id
	private String userid;
	private String name;
	private int amount;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "UserDTO [uid=" + userid + ", name=" + name + ", amount=" + amount + "]";
	}
}
