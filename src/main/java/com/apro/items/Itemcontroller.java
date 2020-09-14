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

public class Itemcontroller implements Initializable {
	Connection conn;

	
	  public Itemcontroller() { conn = SqliteConnection.Connector(); if (conn ==
	  null) { System.out.println("Connection Not Successful");
	  
	 System.exit(1); } } public boolean isDbConnected() { try { return
	  !conn.isClosed(); } catch (SQLException e) { e.printStackTrace(); return
	  false; } }
	  
	  public static Connection Connector() { try {
	 Class.forName("org.sqlite.JDBC"); Connection conn1 =
	  DriverManager.getConnection("jdbc:sqlite:testdb.sqlite"); return conn1; }
	 catch (Exception e) { return null; } }
	 
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
	TextArea pdes= new TextArea();
	@FXML
	Button psave = new Button();
	@FXML
	ComboBox<String> cmbcat;
	@FXML
	ComboBox<String> cmbbrand;
	@FXML
	Label prolblmsg = new Label();
	@FXML
	Button btnprocan = new Button();

	PreparedStatement statement = null;
	PreparedStatement statement1 = null;

	/**
	 * Here we will define the method that builds the List used by the ComboBox
	 */

	private List<String> getbrand() {
		// Define the data you will be returning, in this case, a List of Strings for
		// the ComboBox
		List<String> options = new ArrayList<>();
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:testdb.sqlite");
			String query = "select brandname from brand order by brandname ASC";
			PreparedStatement statement = conn.prepareStatement(query);

			ResultSet set = statement.executeQuery();
			while (set.next()) {
				options.add(set.getString("brandname"));
			}
			statement.close();
			set.close();
			return options;
		} catch (ClassNotFoundException | SQLException ex) {
			return null;
		}
	}

	private List<String> getData() {
		// Define the data you will be returning, in this case, a List of Strings for
		// the ComboBox
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
		cmbbrand.setItems(FXCollections.observableArrayList(getbrand()));
		cmbbrand.setEditable(true);
		TextFields.bindAutoCompletion(cmbbrand.getEditor(), cmbbrand.getItems());
	}

	public void prosave(ActionEvent event) throws SQLException {
		/* prolblmsg.setText("Inserted successfully"); */
		String category = null;
		String brand = null; 
		String a = cmbcat.getSelectionModel().getSelectedItem();
		String query = "select id from tbcat where catname = " + "'"+a+"'";
		System.out.println(query);
		PreparedStatement pp = conn.prepareStatement(query);
		ResultSet rs = pp.executeQuery();
		if(rs.next())
		{
			category = rs.getString("id");
			prolblmsg.setText(rs.getString("id"));
		}
		String c = cmbbrand.getSelectionModel().getSelectedItem();
		String query1 = "select id from brand where brandname = " + "'"+c+"'";
		System.out.println(query1);
		PreparedStatement pp1 = conn.prepareStatement(query1);
		ResultSet rs1 = pp1.executeQuery();
		if(rs1.next())
		{
			brand = rs1.getString("id");
			prolblmsg.setText(rs1.getString("id"));
		}
		try
		{
		String q = "insert into item (iname,catid,bid,sku,desc,hsn,cgst,sgst,igst,cess) values (?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement preps=conn.prepareStatement(q);
		preps.setString(1, pname.getText());
		preps.setString(2, category);
		preps.setString(3, brand);
		preps.setString(4, psku.getText());
		preps.setString(5, pdes.getText());
		preps.setString(6, phsn.getText());
		preps.setString(7, pcgst.getText());
		preps.setString(8, psgst.getText());
		preps.setString(9, pigst.getText());
		preps.setString(10, pcess.getText());
		preps.executeUpdate();
		}
		catch(SQLException ex)
		{
			prolblmsg.setText("Fill all values");
		}
		
		
	}

	/* close code */
	public void procan(ActionEvent evnet) throws SQLException {
		Stage stage = (Stage) btnprocan.getScene().getWindow();
		stage.close();
	}
	//to get value of foreign key
	public void combcat(ActionEvent event) throws SQLException
	{
		
		
	}
}
