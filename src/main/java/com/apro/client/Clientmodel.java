package com.apro.client;

public class Clientmodel {
String id, name, email, phone, address, status;

public Clientmodel(String id, String name, String email, String phone, String address, String status) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.address = address;
	this.status = status;
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}
}
