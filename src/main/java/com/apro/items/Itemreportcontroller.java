package com.apro.items;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
	 
	 conn = SqliteConnection.Connector(); 
		  }
		
		  
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
				String quq = "select catname from tbcat where id="+ rs.getString("catid")+";";
				PreparedStatement stm = conn.prepareStatement(quq);
				ResultSet s = stm.executeQuery();
				System.out.println(s.getString("catname"));
				obist.add(new Itemreportmodel(rs.getString("id"),rs.getString("iname"),s.getString("catname"),rs.getString("desc"), rs.getString("hsn"), rs.getString("sgst"), rs.getString("cgst"), rs.getString("igst"), rs.getString("cess")));
				
				
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
		  
			/*
			 * String qu ="delete from stock;"; PreparedStatement pe =
			 * conn.prepareStatement(qu); pe.executeUpdate(); System.out.println(qu);
			 */
		   
			  String qu ="delete from item where id = " + selitem.id + ";";
			  PreparedStatement pe = conn.prepareStatement(qu); pe.executeUpdate();
			 System.out.println(qu);
		  
	  }
	  
	  public void viewstock(ActionEvent ev) throws IOException
	  {
		  Itemreportmodel selitem = itemtable.getSelectionModel().getSelectedItem();
		  System.out.println(selitem.id.toString());
		  Stage stage=new Stage();
		  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Items/itemstock.fxml"));
		  Parent root = (Parent)fxmlLoader.load();
		  Itemstockcontroller its = fxmlLoader.<Itemstockcontroller>getController();
		  its.setProduct(selitem.id.toString());
		  Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	  }
		  
		 
		  
		  
		  
}

