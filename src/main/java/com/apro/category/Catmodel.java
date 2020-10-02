package com.apro.category;

public class Catmodel {
String id, catname;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getCatname() {
	return catname;
}

public void setCatname(String catname) {
	this.catname = catname;
}

public Catmodel(String id, String catname) {
	super();
	this.id = id;
	this.catname = catname;
}
}
