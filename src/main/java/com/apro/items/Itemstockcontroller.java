package com.apro.items;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.apro.login.SqliteConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Itemstockcontroller implements Initializable{
Connection conn;

@FXML
TableView<Itemstockmodel> tblstock;
@FXML
TableColumn<Itemstockmodel, String> id;
@FXML
TableColumn<Itemstockmodel, String> itemid;
@FXML
TableColumn<Itemstockmodel, String> purid;
@FXML
TableColumn<Itemstockmodel, String> purprice;
@FXML
TableColumn<Itemstockmodel, String> purstock;
@FXML
TableColumn<Itemstockmodel, String> saleprice;
@FXML
TableColumn<Itemstockmodel, String> minprice;
@FXML
TableColumn<Itemstockmodel, String> mrp;
@FXML
TableColumn<Itemstockmodel, String> curstock;
@FXML
TableColumn<Itemstockmodel, String> stockvalue;


public String productid;

public void setProduct(String product)
{
this.productid = product;
System.out.println(productid);

try
{
ResultSet rs = conn.createStatement().executeQuery("select * from stock where itemid="+productid+";");
while(rs.next())
{
	String quq = "select iname from item where id="+ rs.getString("itemid")+";";
	PreparedStatement stm = conn.prepareStatement(quq);
	ResultSet s = stm.executeQuery();
	System.out.println(s.getString("iname"));
	obist.add(new Itemstockmodel(rs.getString("id"), s.getString("iname"), rs.getString("purid"), rs.getString("purprice"), rs.getString("saleprice"), rs.getString("minprice"), rs.getString("mrp"), rs.getString("purstock"), rs.getString("curstock"), rs.getString("stockvalue")));
	
	
}
}
catch (SQLException ex)
{
	System.out.println("Error");
}


id.setCellValueFactory(new PropertyValueFactory<>("id"));
itemid.setCellValueFactory(new PropertyValueFactory<>("itemid"));
purid.setCellValueFactory(new PropertyValueFactory<>("purid"));
purprice.setCellValueFactory(new PropertyValueFactory<>("purpice"));
purstock.setCellValueFactory(new PropertyValueFactory<>("purstock"));
saleprice.setCellValueFactory(new PropertyValueFactory<>("saleprice"));
minprice.setCellValueFactory(new PropertyValueFactory<>("minprice"));
mrp.setCellValueFactory(new PropertyValueFactory<>("mrp"));
curstock.setCellValueFactory(new PropertyValueFactory<>("curstock"));
stockvalue.setCellValueFactory(new PropertyValueFactory<>("stockvalue"));

tblstock.setItems(obist);


}





public Itemstockcontroller(){
	 
	 conn = SqliteConnection.Connector(); 
		  
		  
  }
		






		  ObservableList<Itemstockmodel> obist = FXCollections.observableArrayList();
@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	
	
	
	
	
	
	
	
	
}
}