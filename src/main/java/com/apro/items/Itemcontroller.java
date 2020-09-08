package com.apro.items;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.apro.login.SqliteConnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Itemcontroller {
	Connection conn;

	public Itemcontroller() {
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
	public void invsave(ActionEvent event)
	{
		Connection conection = SqliteConnection.Connector();
		  String query="INSERT INTO item (name,address,phone,email) values (?,?,?,?);";
	}
}
