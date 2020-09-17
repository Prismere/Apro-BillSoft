package com.apro.items;

public class Itemstockmodel {
	String id,itemid,purid,purprice,purstock,saleprice,minprice,mrp,stockvalue,curstock;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getPurid() {
		return purid;
	}

	public void setPurid(String purid) {
		this.purid = purid;
	}

	public String getPurprice() {
		return purprice;
	}

	public void setPurprice(String purprice) {
		this.purprice = purprice;
	}

	public String getPurstock() {
		return purstock;
	}

	public void setPurstock(String purstock) {
		this.purstock = purstock;
	}

	public String getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(String saleprice) {
		this.saleprice = saleprice;
	}

	public String getMinprice() {
		return minprice;
	}

	public void setMinprice(String minprice) {
		this.minprice = minprice;
	}

	public String getMrp() {
		return mrp;
	}

	public void setMrp(String mrp) {
		this.mrp = mrp;
	}

	public String getStockvalue() {
		return stockvalue;
	}

	public void setStockvalue(String stockvalue) {
		this.stockvalue = stockvalue;
	}

	public String getCurstock() {
		return curstock;
	}

	public void setCurstock(String curstock) {
		this.curstock = curstock;
	}

	public Itemstockmodel(String id, String itemid, String purid, String purprice, String purstock, String saleprice,
			String minprice, String mrp, String stockvalue, String curstock) {
		super();
		this.id = id;
		this.itemid = itemid;
		this.purid = purid;
		this.purprice = purprice;
		this.purstock = purstock;
		this.saleprice = saleprice;
		this.minprice = minprice;
		this.mrp = mrp;
		this.stockvalue = stockvalue;
		this.curstock = curstock;
	}

}
