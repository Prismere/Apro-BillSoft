package com.apro.client;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.apro.comfun.Functions;
import com.apro.login.SqliteConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class clientController {
	
	@FXML
	JFXButton view;
	Connection conn;

	public clientController() {
		conn = SqliteConnection.Connector();
	}
	
	
	
	@FXML
	JFXTextField txtclient = new JFXTextField();
	@FXML
	JFXTextField txtcemail = new JFXTextField();
	@FXML
	JFXTextField txtcphone = new JFXTextField();
	@FXML
	JFXTextArea txtcaddress = new JFXTextArea();

	
	
	public void onsave(ActionEvent event) throws SQLException 
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
			Functions.invsave(txtclient.getText() + " inserted successfully");
		
			
		}
		catch(SQLException e){
			Functions.invsave(e.getMessage());
		}
		finally
		{
			cst.close();
		}
		
	}
	
	public void cancelclient(ActionEvent evt)
	{
		Stage stg = (Stage) btncancel.getScene().getWindow();
		stg.close();
	}
	
	public void onview(ActionEvent ev) throws IOException
	{
		Scene scene1 = (Scene)view.getScene();
		scene1.getStylesheets();
		
		String s = scene1.getStylesheets().toString();
		
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Clients/clientsearch.fxml"));
		Scene scene = new Scene(root);
		
		Stage stage = new Stage();
		 stage.initModality(Modality.APPLICATION_MODAL);
		 stage.setTitle("Apro Billing Software:: Version 1.0"); 
		   stage.initStyle(StageStyle.UTILITY);
		   if(s.equals("[/styles/Dark.css]"))
			{
		   scene.getStylesheets().add("/styles/Dark.css");
		   stage.setScene(scene);
		   stage.setResizable(false);
		   stage.show();
		}
		   else
		   {
			   scene.getStylesheets().add("/styles/main.css");
			   stage.setScene(scene);
			   stage.setResizable(false);
			   stage.show();
		   }
	}
	@FXML
	Button btncancel = new Button();
	public void oncan(ActionEvent event)
	{
		Stage stage = (Stage) btncancel.getScene().getWindow();
		stage.close();
	}
}
