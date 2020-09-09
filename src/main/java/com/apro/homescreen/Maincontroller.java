package com.apro.homescreen;

import java.sql.Connection;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import org.sqlite.SQLiteConnection;

import com.apro.login.SqliteConnection;

public class Maincontroller {
	@FXML	
	AnchorPane newitem = new AnchorPane();
	@FXML
	VBox all = new VBox();
	@FXML
	AnchorPane brandbox = new AnchorPane();
	
	@FXML
	public void viewinv()
	{
		try
		{
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/items.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("Inventory:: Version 1.0"); 
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setScene(scene);
		/* stage.setMaximized(true); */
		stage.show();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	public void newbrand()
	{
		try
		{
		all.setDisable(true);
		brandbox.toFront();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/brand.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("Inventory:: Version 1.0"); 
		stage.initStyle(StageStyle.UNDECORATED);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		/* stage.setMaximized(true); */
		stage.show();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	public void newcategory()
	{
		try
		{
			all.setDisable(true);
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/category.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("Inventory:: Version 1.0"); 
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setScene(scene);
		/* stage.setMaximized(true); */
		stage.show();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	
}
