package com.apro.brand;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.apro.comfun.Functions;
import com.apro.login.SqliteConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Newbrandcontroller {

	Connection conn;
	@FXML
	JFXButton btncan,view;
	public Newbrandcontroller(){
	conn=SqliteConnection.Connector();
	}
	@FXML
	JFXTextField txtbrand = new JFXTextField();
	public void onsave(ActionEvent event) throws SQLException
	{
		String query = "insert into brand (brandname) values (?);";
		PreparedStatement bst = conn.prepareStatement(query);
		try {
			bst.setString(1, txtbrand.getText().toUpperCase());
			bst.executeUpdate();
			Functions.invsave(txtbrand.getText() + " inserted succesfully");
			
		}
		catch(SQLException e){
			Functions.invsave(e.getMessage());
		}
		finally
		{
			bst.close();
		}				
		txtbrand.setText(null);
	}
	public void oncan(ActionEvent e) 
	{
		Stage stg = (Stage) btncan.getScene().getWindow();
		stg.close();
	}
	public void onbrand(ActionEvent e) throws IOException
	{
		Scene scene1 = (Scene)view.getScene();
		scene1.getStylesheets();
		String s = scene1.getStylesheets().toString();
		
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/brandsearch.fxml"));
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
}
