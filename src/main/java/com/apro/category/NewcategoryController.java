package com.apro.category;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.apro.comfun.Functions;
import com.apro.login.SqliteConnection;
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

	public NewcategoryController(){
				conn=SqliteConnection.Connector();
			}
	public void onsave(ActionEvent event) throws SQLException
	{
		String query = "insert into tbcat (catname) values (?);";	
		PreparedStatement prep= conn.prepareStatement(query);
		
		try
		{ 	
			prep.setString(1,catname.getText());
			prep.executeUpdate();
			Functions.invsave(catname.getText() + " is inserted");
		}
		catch(SQLException e)
		{
		
			Functions.invsave(e.getMessage());
		}
		finally
		{
			prep.close();
		}
	}
	public void onview(ActionEvent e) throws IOException
	{
		
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/catsearch.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		 stage.initModality(Modality.APPLICATION_MODAL);
		 stage.setTitle("Apro Billing Software:: Version 1.0"); 
		   stage.initStyle(StageStyle.UTILITY);
		   stage.setScene(scene);
		   stage.setResizable(false);
		   stage.show();	
	}
	
}
