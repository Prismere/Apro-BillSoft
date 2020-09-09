package com.apro.brand;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.apro.login.SqliteConnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;


public class Brandcontroller {
	Connection conn;
	@FXML
	AnchorPane brandbox = new AnchorPane();
	
	
	
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
	TextField brandname = new TextField();
	public void brandsave(ActionEvent event) throws SQLException 
	{
		String query = "insert into brand (brandname) values (?);";
		PreparedStatement prep= conn.prepareStatement(query);
		try
		{
			prep.setString(1,brandname.getText());
			prep.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Cannot be inserted");
		}
	}
	public void brandcan(ActionEvent event) throws IOException
	{
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
		Scene main = new Scene(root);
		Window mainwin = ((Node) event.getSource()).getScene().getWindow();
		Stage mainstage =  new Stage();
		mainstage.initOwner(mainwin);
		mainstage.setScene(main);
		mainstage.setMaximized(true);
		mainstage.show();
	}
}
