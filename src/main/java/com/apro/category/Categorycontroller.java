package com.apro.category;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.apro.login.SqliteConnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Categorycontroller {
	Connection conn;

	public Categorycontroller() {
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
	TextField catname = new TextField();
	public void catsave(ActionEvent event)  throws SQLException 
	{
		String query = "insert into category (catname) values (?);";
		PreparedStatement prep= conn.prepareStatement(query);
		try
		{
			prep.setString(1,catname.getText());
			prep.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Cannot be inserted");
		}
	}
	
	
}
