package com.apro.invoices;

public class Invoicemodel {
String id, catname;

public Invoicemodel(String id, String catname) {
	
	this.id = id;
	this.catname = catname;
}

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

}
