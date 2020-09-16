package com.apro.items;

public class Itemreportmodel {
String id,iname,catid,desc,hsn,cgst,sgst,igst,cess;

public Itemreportmodel(String id, String iname, String catid, String desc, String hsn, String cgst, String sgst,
		String igst, String cess) {
	
	this.id = id;
	this.iname = iname;
	this.catid = catid;
	this.desc = desc;
	this.hsn = hsn;
	this.cgst = cgst;
	this.sgst = sgst;
	this.igst = igst;
	this.cess = cess;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getIname() {
	return iname;
}

public void setIname(String iname) {
	this.iname = iname;
}

public String getCatid() {
	return catid;
}

public void setCatid(String catid) {
	this.catid = catid;
}

public String getDesc() {
	return desc;
}

public void setDesc(String desc) {
	this.desc = desc;
}

public String getHsn() {
	return hsn;
}

public void setHsn(String hsn) {
	this.hsn = hsn;
}

public String getCgst() {
	return cgst;
}

public void setCgst(String cgst) {
	this.cgst = cgst;
}

public String getSgst() {
	return sgst;
}

public void setSgst(String sgst) {
	this.sgst = sgst;
}

public String getIgst() {
	return igst;
}

public void setIgst(String igst) {
	this.igst = igst;
}

public String getCess() {
	return cess;
}

public void setCess(String cess) {
	this.cess = cess;
}

}
