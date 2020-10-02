package com.apro.vendor;

public class Venmodel {
	String id, vname,vemail,vphone,vtin,vpan,vgst,vaddress,vcode,status;
public Venmodel(String id, String vname, String vemail, String vphone, String vtin, String vpan, String vgst,
			String vaddress, String vcode, String status) {
		
		this.id = id;
		this.vname = vname;
		this.vemail = vemail;
		this.vphone = vphone;
		this.vtin = vtin;
		this.vpan = vpan;
		this.vgst = vgst;
		this.vaddress = vaddress;
		this.vcode = vcode;
		this.status = status;
	}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getVname() {
	return vname;
}

public void setVname(String vname) {
	this.vname = vname;
}

public String getVemail() {
	return vemail;
}

public void setVemail(String vemail) {
	this.vemail = vemail;
}

public String getVphone() {
	return vphone;
}

public void setVphone(String vphone) {
	this.vphone = vphone;
}

public String getVtin() {
	return vtin;
}

public void setVtin(String vtin) {
	this.vtin = vtin;
}

public String getVpan() {
	return vpan;
}

public void setVpan(String vpan) {
	this.vpan = vpan;
}

public String getVgst() {
	return vgst;
}

public void setVgst(String vgst) {
	this.vgst = vgst;
}

public String getVaddress() {
	return vaddress;
}

public void setVaddress(String vaddress) {
	this.vaddress = vaddress;
}

public String getVcode() {
	return vcode;
}

public void setVcode(String vcode) {
	this.vcode = vcode;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}


}
