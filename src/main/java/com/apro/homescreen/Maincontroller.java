package com.apro.homescreen;


import java.sql.Connection;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import org.sqlite.SQLiteConnection;

import com.apro.login.SqliteConnection;

public class Maincontroller {
	@FXML	
	AnchorPane newitem = new AnchorPane();

	@FXML
	public void addprod()
	{
		try
		{
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/items.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("Apro Billing Software:: Version 1.0"); 
		
		/* make only foreground window active*/
		stage.initModality(Modality.APPLICATION_MODAL);
	
		stage.initStyle(StageStyle.UTILITY);
		stage.setScene(scene);
		/* stage.setMaximized(true); */
		stage.setResizable(false);
		stage.show();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
   public void addbrand(ActionEvent ev)
   {
	   try
		{
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/newbrand.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("Apro Billing Software:: Version 1.0"); 
		
		/* make only foreground window active*/
		stage.initModality(Modality.APPLICATION_MODAL);
		
		stage.initStyle(StageStyle.UTILITY);
		stage.setScene(scene);
		/* stage.setMaximized(true); */
		stage.setResizable(false);
		stage.show();
	} catch (Exception e) {
		e.printStackTrace();
	}
   }
   
   public void addcat(ActionEvent ev)
   {
	   try
		{
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/newcategory.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("Apro Billing Software:: Version 1.0"); 
		
		/* make only foreground window active*/
		stage.initModality(Modality.APPLICATION_MODAL);
		
		stage.initStyle(StageStyle.UTILITY);
		stage.setScene(scene);
		/* stage.setMaximized(true); */
		stage.setResizable(false);
		stage.show();
	} catch (Exception e) {
		e.printStackTrace();
	}
   }
   public void btnbtn(ActionEvent event)
   {

	   try
		{
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Invoices/invoicereport.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("Apro Billing Software:: Version 1.0"); 
		
		/* make only foreground window active*/
		stage.initModality(Modality.APPLICATION_MODAL);
		
		stage.initStyle(StageStyle.UTILITY);
		stage.setScene(scene);
		/* stage.setMaximized(true); */
		stage.setResizable(false);
		stage.show();
	} catch (Exception e) {
		e.printStackTrace();
	}
   }
   public void newinvoice(ActionEvent event)
   {
	   try
		{
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Invoices/invoice.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("Apro Billing Software:: Version 1.0"); 
		
		/* make only foreground window active*/
		stage.initModality(Modality.APPLICATION_MODAL);
		
		stage.initStyle(StageStyle.UTILITY);
		stage.setScene(scene);
		/* stage.setMaximized(true); */
		stage.setResizable(false);
		stage.show();
	} catch (Exception e) {
		e.printStackTrace();
	}
   }
   public void addclient(ActionEvent event)
   {
	   try
		{
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Clients/newclient.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("Apro Billing Software:: Version 1.0"); 
		
		/* make only foreground window active*/
		stage.initModality(Modality.APPLICATION_MODAL);
		
		stage.initStyle(StageStyle.UTILITY);
		stage.setScene(scene);
		/* stage.setMaximized(true); */
		stage.setResizable(false);
		stage.show();
	} catch (Exception e) {
		e.printStackTrace();
	}
   }
   
   public void itemreport(ActionEvent event)
   {
	   
	   try {
		   Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/newitemsreport.fxml"));
		   Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setTitle("Apro Billing Software:: Version 1.0"); 
			
			/* make only foreground window active*/
			stage.initModality(Modality.APPLICATION_MODAL);
			
			stage.initStyle(StageStyle.UTILITY);
			stage.setScene(scene);
			/* stage.setMaximized(true); */
			stage.setResizable(false);
			stage.show(); 
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   
   }
   
   public void viewvendor(ActionEvent ev)
   {
	   try {
		   Parent root = FXMLLoader.load(getClass().getResource("/fxml/Vendor/newvendor.fxml"));
		   Scene scene = new Scene(root);
		   Stage stage = new Stage();
		   stage.setTitle("Apro Billing Software:: Version 1.0"); 
		   
		   /* make only foreground active */
		   stage.initModality(Modality.APPLICATION_MODAL);
		   stage.isResizable();
		   stage.initStyle(StageStyle.UTILITY);
		   stage.setScene(scene);
		   stage.setResizable(false);
		   
		   stage.show();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   
   public void purchase(ActionEvent eve)
   {
	   try {
		   Parent root = FXMLLoader.load(getClass().getResource("/fxml/Purchase/purchase.fxml"));
		   Scene scene = new Scene(root);
		   Stage stage = new Stage();
		   stage.setTitle("Apro Billing Software:: Version 1.0"); 
		   
		   /* make only foreground active */
		   stage.initModality(Modality.APPLICATION_MODAL);
		   
		   stage.initStyle(StageStyle.UTILITY);
		   stage.setScene(scene);
		   stage.setResizable(false);
		   stage.show();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   
}




