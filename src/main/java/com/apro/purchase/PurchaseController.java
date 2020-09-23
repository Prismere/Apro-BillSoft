package com.apro.purchase;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import com.apro.login.SqliteConnection;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PurchaseController implements Initializable{
	
	@FXML
	ComboBox<String> cmbvendor = new ComboBox<String>();

	@FXML
	ComboBox<String> cmbpro = new ComboBox<String>();
	@FXML
	TextField itemdesc = new TextField();
	@FXML
	TextField qty = new TextField();
	@FXML
	TextField up = new TextField();
	@FXML
	TextField disc = new TextField();
	@FXML
	TextField tax = new TextField();
	
	

	Connection conn;
	 public PurchaseController() {
		 
		 conn = SqliteConnection.Connector(); if (conn ==
			  null) { System.out.println("Connection Not Successful");
			  
			 System.exit(1); } } public boolean isDbConnected() { try { return
			  !conn.isClosed(); } catch (SQLException e) { e.printStackTrace(); return
			  false; } }
			  
			  public static Connection Connector() { try {
			 Class.forName("org.sqlite.JDBC"); Connection conn1 =
			  DriverManager.getConnection("jdbc:sqlite:testdb.sqlite"); return conn1; }
			 catch (Exception e) { return null; } }
			@Override
			public void initialize(URL location, ResourceBundle resources) {
				// TODO Auto-generated method stub
				
				
				cmbvendor.setItems(FXCollections.observableArrayList(getvendor()));
				cmbvendor.setEditable(true);
				TextFields.bindAutoCompletion(cmbvendor.getEditor(), cmbvendor.getItems());
				
				try {
					cmbpro.setItems(FXCollections.observableArrayList(getProduct()));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cmbpro.setEditable(true);
				TextFields.bindAutoCompletion(cmbpro.getEditor(), cmbpro.getItems());
				
				
			}

			


private List<String> getvendor(){
	
	List<String> vendors = new ArrayList<>();
	
	try {
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:testdb.sqlite");
		String query = "select vname from vendor order by vname ASC";
		PreparedStatement statement = conn.prepareStatement(query);

		ResultSet set = statement.executeQuery();
		while (set.next()) {
			vendors.add(set.getString("vname"));
		}
		statement.close();
		set.close();
		return vendors;
		
	}
	catch(ClassNotFoundException | SQLException ex) {
		System.out.println(ex.getMessage());
		return null;
	}
	
}

private List<String> getProduct() throws SQLException{
	
	List<String> items = new ArrayList<>();
	ResultSet set = null;
	try {
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:testdb.sqlite");
		String query = "select iname from item order by iname ASC";
		PreparedStatement statement = conn.prepareStatement(query);

		set = statement.executeQuery();
		while (set.next()) {
			items.add(set.getString("iname"));
		}
		statement.close();
		return items;
		
	}
	catch(ClassNotFoundException | SQLException ex) {
		System.out.println(ex.getMessage());
		return null;
	}

}
	
public void selecteditem(ActionEvent ev)
{
	System.out.println(cmbpro.getValue());
	ResultSet items = null;
	String query = "select * from item where iname = '"+ cmbpro.getValue().toString() +"';";
	try {
		
		
		PreparedStatement fetchproduct = conn.prepareStatement(query);
	    items = fetchproduct.executeQuery();
	    System.out.println(items.getString("desc"));
	    itemdesc.setText(items.getString("desc"));
	    qty.setText("1");
	    System.out.println(items.getString("id"));
	    
	} 
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
			
}

