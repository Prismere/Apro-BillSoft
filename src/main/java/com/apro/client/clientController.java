package com.apro.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.apro.login.SqliteConnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class clientController {
	
	
	Connection conn;

	public clientController() {
		conn = SqliteConnection.Connector();
		if (conn == null) {
			System.out.println("Connection Not Successful");

			System.exit(1);
		}
	}

	public boolean isDbConnected() {
		try {
			return !conn.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static Connection Connector() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn1 = DriverManager.getConnection("jdbc:sqlite:testdb.sqlite");
			return conn1;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	@FXML
	TextField txtclient = new TextField();
	@FXML
	TextField txtcemail = new TextField();
	@FXML
	TextField txtcphone = new TextField();
	@FXML
	TextArea txtcaddress = new TextArea();
	@FXML
	Label lblmsg = new Label();
	@FXML
	Button btncancel = new Button();
	
	
	public void saveclient(ActionEvent event) throws SQLException 
	{
		String query = "insert into client (name,address,email,phone,status) values (?,?,?,?,?);";
		
		PreparedStatement cst = conn.prepareStatement(query);
		
	
		try {
			cst.setString(1, txtclient.getText());
			cst.setString(2, txtcaddress.getText());
			cst.setString(3, txtcemail.getText());
			cst.setString(4, txtcphone.getText());
			cst.setString(5, "1");
			cst.executeUpdate();
			
			
			/*
			 * lblmsg.setTextFill(Color.web("#080000"));
			 * lblmsg.setText("Successfully inserted " + txtclient.getText());
			 */
			
		}
		catch(SQLException e){
			lblmsg.setText("Client Already Exists");
		}
		
		
	}
	
	public void cancelclient(ActionEvent evt)
	{
		Stage stg = (Stage) btncancel.getScene().getWindow();
		stg.close();
	}
	
	
	
}
