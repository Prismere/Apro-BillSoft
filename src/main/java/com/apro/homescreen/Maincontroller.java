package com.apro.homescreen;

import java.sql.Connection;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import org.sqlite.SQLiteConnection;

import com.apro.login.SqliteConnection;

public class Maincontroller {
	@FXML	
	AnchorPane newitem = new AnchorPane();
	@FXML
	public void viewinv()
	{
		try
		{
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
