package com.apro.items;

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
import com.sun.glass.events.KeyEvent;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Itemcontroller implements Initializable{
	Connection conn;

	/*
	 * public Itemcontroller() { conn = SqliteConnection.Connector(); if (conn ==
	 * null) { System.out.println("Connection Not Successful");
	 * 
	 * System.exit(1); } } public boolean isDbConnected() { try { return
	 * !conn.isClosed(); } catch (SQLException e) { e.printStackTrace(); return
	 * false; } }
	 * 
	 * public static Connection Connector() { try {
	 * Class.forName("org.sqlite.JDBC"); Connection conn1 =
	 * DriverManager.getConnection("jdbc:sqlite:testdb.sqlite"); return conn1; }
	 * catch (Exception e) { return null; } }
	 */
	@FXML
	TextField pname = new TextField();
	@FXML
	TextField psku = new TextField();
	@FXML
	TextField phsn = new TextField();
	@FXML
	TextField pprice = new TextField();
	@FXML
	TextField psale = new TextField();
	@FXML
	TextField pcgst = new TextField();
	@FXML
	TextField pigst = new TextField();
	@FXML
	TextField pmin = new TextField();
	@FXML
	TextField pmrp = new TextField();
	@FXML
	TextField psgst = new TextField();
	@FXML
	TextField pcess = new TextField();
	@FXML
	TextField pstock = new TextField();
	@FXML
	TextField psvalue = new TextField();
	@FXML
	Button psave = new Button();
	@FXML
			ComboBox<String> cmbcat;
	@FXML
	Label prolblmsg = new Label();
	@FXML 
Button btnprocan = new Button();
	
	PreparedStatement statement = null;
	
	 /**
	     * Here we will define the method that builds the List used by the ComboBox
	     */
	    private List<String> getData() {


	        // Define the data you will be returning, in this case, a List of Strings for the ComboBox
	        List<String> options = new ArrayList<>();
	        
	        try {
	        	Class.forName("org.sqlite.JDBC");
				Connection conn = DriverManager.getConnection("jdbc:sqlite:testdb.sqlite");
	            String query = "select catname from tbcat order by catname ASC";
	            PreparedStatement statement = conn.prepareStatement(query);
	            
	            ResultSet set = statement.executeQuery();
	            
	            while (set.next()) {
	                options.add(set.getString("catname"));
	               
	            }
	            
	            statement.close();
	            set.close();
	          
	            // Return the List
	            return options;
	            

	        } catch (ClassNotFoundException | SQLException ex) {
	            return null;
	        }
	       
	    }
	   
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		cmbcat.setItems(FXCollections.observableArrayList(getData()));
		 cmbcat.setEditable(true);
         TextFields.bindAutoCompletion(cmbcat.getEditor(), cmbcat.getItems());
	}
	public void prosave(ActionEvent event)
	{
		prolblmsg.setText("Inserted successfully");
	}
	/* close code */
	public void procan(ActionEvent evnet)
	{
		   Stage stage = (Stage) btnprocan.getScene().getWindow();
		   stage.close();
	}
}
