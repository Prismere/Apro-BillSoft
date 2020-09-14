package com.apro.category;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.apro.login.SqliteConnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Categorycontroller {
	Connection conn;

	public Categorycontroller() {
		conn = SqliteConnection.Connector();
		if (conn == null) {
			System.out.println("Connection Not Successful");

			System.exit(1);
		}
	}

	

	/*
	 * String qq = "Delete from item"; PreparedStatement qqq =
	 * conn.prepareStatement("delete from item"); qqq.executeUpdate();
	 */
	
	
	
	
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
	TextField catname = new TextField();
	@FXML
	Label lblmsg = new Label();
	@FXML 
	Button btncan = new Button();
	public void catsave(ActionEvent event)  throws SQLException 
	{ 
		String query = "insert into tbcat (catname) values (?);";	
		PreparedStatement prep= conn.prepareStatement(query);
		String catn = catname.getText();
		try
		{ 	
			prep.setString(1,catname.getText());
			prep.executeUpdate();
			lblmsg.setTextFill(Color.web("#008000"));
			lblmsg.setText("Successfully added " + "'" + catn + "'");
		}
		catch(SQLException e)
		{
			lblmsg.setText("Category already exists in database");
			System.out.println("Cannot be inserted");
		}
	}
	
	public void cancelcat(ActionEvent event)
	{
		Stage stg = (Stage) btncan.getScene().getWindow();
		stg.close();
	}
}
