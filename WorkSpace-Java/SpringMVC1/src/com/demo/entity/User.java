package com.demo.entity;

import java.io.Serializable;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6240633172812708760L;
	
	private String id;
	private String name;
	private String phone;
	private String campus_card;
	
	public User() {
	}
	public User(String id, String name, String phone, String campusCard) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.campus_card = campusCard;
	}
	public User(String name, String phone, String campusCard) {
		super();
		this.name = name;
		this.phone = phone;
		this.campus_card = campusCard;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCampus_card() {
		return campus_card;
	}
	public void setCampus_card(String campusCard) {
		campus_card = campusCard;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (campus_card == null) {
			if (other.campus_card != null)
				return false;
		} else if (!campus_card.equals(other.campus_card))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [campus_card=" + campus_card + ", id=" + id + ", name="
				+ name + ", phone=" + phone + "]";
	}
	
}
