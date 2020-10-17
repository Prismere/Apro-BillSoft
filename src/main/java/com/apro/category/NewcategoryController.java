package com.apro.category;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.apro.comfun.Functions;
import com.apro.login.SqliteConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class NewcategoryController{
Connection conn;
@FXML
JFXTextField catname = new JFXTextField();
@FXML
JFXButton view;

	public NewcategoryController(){
				conn=SqliteConnection.Connector();
			}
	public void onsave(ActionEvent event) throws SQLException
	{
		String query = "insert into tbcat (catname) values (?);";	
		PreparedStatement prep= conn.prepareStatement(query);
		
		try
		{ 	
			prep.setString(1,catname.getText().toUpperCase());
			prep.executeUpdate();
			Functions.invsave(catname.getText() + " is inserted");
			catname.setText(null);
		}
		catch(SQLException e)
		{
		
			Functions.invsave("This category already exists");
		}
		finally
		{
			prep.close();
		}
	}
	public void ontype(ActionEvent event) throws SQLException
	{
		String query = "insert into tbcat (catname) values (?);";	
		PreparedStatement prep= conn.prepareStatement(query);
		
		try
		{ 	
			prep.setString(1,catname.getText().toUpperCase());
			prep.executeUpdate();
			Functions.invsave(catname.getText() + " is inserted");
			catname.setText(null);
		}
		catch(SQLException e)
		{
		
			Functions.invsave("This category already exists");
		}
		finally
		{
			prep.close();
		}
	}
	public void onview(ActionEvent e) throws IOException
	{
		Scene scene1 = (Scene)view.getScene();
		scene1.getStylesheets();
		String s = scene1.getStylesheets().toString();
		
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/catsearch.fxml"));
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
			   stage.setScene(scene);
			   stage.setResizable(false);
			   stage.show();
		   }
	}
	@FXML
	JFXButton btncancel = new JFXButton();
	public void oncan(ActionEvent event)
	{
		Stage stage = (Stage) btncancel.getScene().getWindow();
		stage.close();
	}
}
