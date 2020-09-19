package com.apro.invoices;

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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Invoicecontroller implements Initializable {
	Connection conn;
	 public Invoicecontroller() {
		 
		 conn = SqliteConnection.Connector(); if (conn ==
			  null) { System.out.println("Connection Not Successful");
			  
			 System.exit(1); } } public boolean isDbConnected() { try { return
			  !conn.isClosed(); } catch (SQLException e) { e.printStackTrace(); return
			  false; } }
			  
			  public static Connection Connector() { try {
			 Class.forName("org.sqlite.JDBC"); Connection conn1 =
			  DriverManager.getConnection("jdbc:sqlite:testdb.sqlite"); return conn1; }
			 catch (Exception e) { return null; } }
	
	
	
@FXML
Button btncan = new Button();
@FXML
Label txtsub = new Label();
@FXML
Label txtgst = new Label();
@FXML
Label txttot=new Label();
@FXML
Label txtdis = new Label();
@FXML
ComboBox<String> cmbpro;
@FXML
ComboBox<String> cmbclient;

private List<String> getclient() {
	// Define the data you will be returning, in this case, a List of Strings for
	// the ComboBox
	List<String> options = new ArrayList<>();
	try {
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:testdb.sqlite");
		String query = "select name from client order by name ASC";
		PreparedStatement statement = conn.prepareStatement(query);

		ResultSet set = statement.executeQuery();
		while (set.next()) {
			options.add(set.getString("name"));
		}
		statement.close();
		set.close();
		return options;
	} catch (ClassNotFoundException | SQLException ex) {
		return null;
	}
}


public void invcancel(ActionEvent event)
{
	Stage stage = (Stage) btncan.getScene().getWindow();
	stage.close();
}



public void saveinvoice(ActionEvent e)
{
	try
	{
	Parent root = FXMLLoader.load(getClass().getResource("/fxml/Report/prodbill.fxml"));
	Scene scene = new Scene(root);
	Stage stage = new Stage();
	stage.setTitle("Inventory:: Version 1.0"); 
	
	/* make only foreground window active*/
	stage.initModality(Modality.APPLICATION_MODAL);
	
	stage.initStyle(StageStyle.UNDECORATED);
	stage.setScene(scene);
	/* stage.setMaximized(true); */
	stage.show();
} catch (Exception e2) {
	e2.printStackTrace();
}
}

@Override
public void initialize(URL location, ResourceBundle resources) {
	cmbclient.setItems(FXCollections.observableArrayList(getclient()));
	cmbclient.setEditable(true);
	TextFields.bindAutoCompletion(cmbclient.getEditor(), cmbclient.getItems());
	
}
}
