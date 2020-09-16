package com.apro.items;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.apro.invoices.Invoicemodel;
import com.apro.login.SqliteConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Itemreportcontroller implements Initializable{
	Connection conn;
	
	
	@FXML
	TableView<Itemreportmodel> itemtable;
	@FXML
	TableColumn<Itemreportmodel, String> iname;
	@FXML
	TableColumn<Itemreportmodel, String> id;
	@FXML
	TableColumn<Itemreportmodel, String> desc;
	@FXML
	TableColumn<Itemreportmodel, String> catid;
	@FXML
	TableColumn<Itemreportmodel, String> hsn;
	@FXML
	TableColumn<Itemreportmodel, String> cgst;
	@FXML
	TableColumn<Itemreportmodel, String> sgst;
	@FXML
	TableColumn<Itemreportmodel, String> igst;
	@FXML
	TableColumn<Itemreportmodel, String> cess;
	
	
	
	
	
	
	
	
	
	
public Itemreportcontroller(){
	 
	 conn = SqliteConnection.Connector(); if (conn ==
		  null) { System.out.println("Connection Not Successful");
		  
		 System.exit(1); } } public boolean isDbConnected() { try { return
		  !conn.isClosed(); } catch (SQLException e) { e.printStackTrace(); return
		  false; } }
		  
		  public static Connection Connector() { try {
		 Class.forName("org.sqlite.JDBC"); Connection conn1 =
		  DriverManager.getConnection("jdbc:sqlite:testdb.sqlite"); return conn1; }
		 catch (Exception e) { return null; } }
		
		  
		  ObservableList<Itemreportmodel> obist = FXCollections.observableArrayList();
	  @Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
			// TODO Auto-generated method stub
			try
			{
			ResultSet rs = conn.createStatement().executeQuery("select * from item");
			while(rs.next())
			{
				obist.add(new Itemreportmodel(rs.getString("id"),rs.getString("iname"),rs.getString("catid"),rs.getString("desc"), rs.getString("hsn"), rs.getString("sgst"), rs.getString("cgst"), rs.getString("igst"), rs.getString("cess")));
			}
			}
			catch (SQLException ex)
			{
				System.out.println("Error");
			}
			id.setCellValueFactory(new PropertyValueFactory<>("id"));
			iname.setCellValueFactory(new PropertyValueFactory<>("iname"));
			desc.setCellValueFactory(new PropertyValueFactory<>("desc"));
			catid.setCellValueFactory(new PropertyValueFactory<>("catid"));
			hsn.setCellValueFactory(new PropertyValueFactory<>("hsn"));
			sgst.setCellValueFactory(new PropertyValueFactory<>("sgst"));
			cgst.setCellValueFactory(new PropertyValueFactory<>("cgst"));
			igst.setCellValueFactory(new PropertyValueFactory<>("igst"));
			cess.setCellValueFactory(new PropertyValueFactory<>("cess"));
			itemtable.setItems(obist);
			
			
		}
	  
	  
	  public void delentry(ActionEvent ev) throws SQLException
	  {
		  Itemreportmodel selitem = itemtable.getSelectionModel().getSelectedItem();
		  itemtable.getItems().remove(selitem);
		  
		  String qu ="delete from item where id = " + selitem.id + ";";
		  PreparedStatement pe = conn.prepareStatement(qu);
		  pe.executeUpdate();
		  System.out.println(qu);
		  
	  }
		  
		 
		  
		  
		  
}

