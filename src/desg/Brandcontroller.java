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
		finally
		{
			bst.close();
		}
	}
	
	public void cancelbrand(ActionEvent evt)
	{
		Stage stg = (Stage) btncancel.getScene().getWindow();
		stg.close();
	}
	
	
	}
