package com.apro.brand;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.apro.login.SqliteConnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Brandcontroller {

	Connection conn;

	public Brandcontroller() {
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
	TextField txtbrandname = new TextField();
	@FXML
	Label lblmsg = new Label();
	@FXML
	Button btncancel = new Button();
	
	public void savebrand(ActionEvent event) throws SQLException 
	{
		String query = "insert into brand (brandname) values (?);";
		PreparedStatement bst = conn.prepareStatement(query);
		try {
			bst.setString(1, txtbrandname.getText());
			bst.executeUpdate();
			lblmsg.setTextFill(Color.web("#080000"));
			lblmsg.setText("Successfully inseted " + txtbrandname.getText());
			
		}
		catch(SQLException e){
			lblmsg.setText("Brand Already Exists");
		}
	}
	
	public void cancelbrand(ActionEvent evt)
	{
		Stage stg = (Stage) btncancel.getScene().getWindow();
		stg.close();
	}
	
	
	}
