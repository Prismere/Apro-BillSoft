package com.apro.brand;

public class Brandsearchmodel {
String id, brandname;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getBrandname() {
	return brandname;
}

public void setBrandname(String brandname) {
	this.brandname = brandname;
}

public Brandsearchmodel(String id, String brandname) {
	this.id = id;
	this.brandname = brandname;
}
}
