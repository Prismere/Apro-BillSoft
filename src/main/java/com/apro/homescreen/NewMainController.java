package com.apro.homescreen;

import java.io.IOException;
import java.util.Optional;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXNodesList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class NewMainController extends Application{
	private Stage mainStage;
	@FXML
	JFXButton btnref=new JFXButton();
	@FXML
	JFXNodesList invnode = new JFXNodesList();
	JFXColorPicker cp = new JFXColorPicker();
	public void refresh(ActionEvent e) throws IOException
	{
		Stage stage1 = (Stage) btnref.getScene().getWindow();
		stage1.close();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/newdash.fxml"));
		Scene scene = new Scene(root);
		
		Stage stage = new Stage();
		 stage.initModality(Modality.APPLICATION_MODAL);
		 stage.setTitle("Apro Billing Software:: Version 1.0"); 
		   stage.initStyle(StageStyle.UTILITY);
		   stage.setScene(scene);
		   stage.setResizable(false);
		   stage.show();
	}
	public void clientview(ActionEvent e) throws IOException
	{
		invnode.animateList(false);
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Clients/newclient.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		 stage.initModality(Modality.APPLICATION_MODAL);
		 stage.setTitle("Apro Billing Software:: Version 1.0"); 
		   stage.initStyle(StageStyle.UTILITY);
		   stage.setScene(scene);
		   stage.setResizable(false);
		   stage.show();
		
	}
	public void newitem(ActionEvent e) throws IOException
	{
		invnode.animateList(false);
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/newitem.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		 stage.initModality(Modality.APPLICATION_MODAL);
		 stage.setTitle("Apro Billing Software:: Version 1.0"); 
		   stage.initStyle(StageStyle.UTILITY);
		   stage.setScene(scene);
		   stage.setResizable(false);
		   stage.show();
	}
	public void vendorview(ActionEvent e) throws IOException
	{
		invnode.animateList(false);
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Vendor/newvendor.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		 stage.initModality(Modality.APPLICATION_MODAL);
		 stage.setTitle("Apro Billing Software:: Version 1.0"); 
		   stage.initStyle(StageStyle.UTILITY);
		   stage.setScene(scene);
		   stage.setResizable(false);
		   stage.show();
	}
	public void brandview (ActionEvent e) throws IOException
	{
		invnode.animateList(false);
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/newbrand.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		 stage.initModality(Modality.APPLICATION_MODAL);
		 stage.setTitle("Apro Billing Software:: Version 1.0"); 
		   stage.initStyle(StageStyle.UTILITY);
		   stage.setScene(scene);
		   stage.setResizable(false);
		   stage.show();
	}

	public void catview (ActionEvent e) throws IOException
	{
		invnode.animateList(false);
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/newcategory.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		 stage.initModality(Modality.APPLICATION_MODAL);
		 stage.setTitle("Apro Billing Software:: Version 1.0"); 
		   stage.initStyle(StageStyle.UTILITY);
		   stage.setScene(scene);
		   stage.setResizable(false);
		   stage.show();
	}
	public void purview(ActionEvent e) throws IOException
	{
		invnode.animateList(false);
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Purchase/newpurchase.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		 stage.initModality(Modality.APPLICATION_MODAL);
		 stage.setTitle("Apro Billing Software:: Version 1.0"); 
		   stage.initStyle(StageStyle.UTILITY);
		   stage.setScene(scene);
		   stage.setResizable(false);
		   stage.show();
	}
	public void saleview(ActionEvent e)
	{
		
	}
	public void repview(ActionEvent e)
	{
		
	}
	public void onsearch(ActionEvent e) throws IOException
	{
		invnode.animateList(false);
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/newitemstock.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		 stage.initModality(Modality.APPLICATION_MODAL);
		 stage.setTitle("Apro Billing Software:: Version 1.0"); 
		   stage.initStyle(StageStyle.UTILITY);
		   stage.setScene(scene);
		   stage.setResizable(false);
		   stage.show();
	}
	public void ondarktheme(ActionEvent e) throws IOException
	{
		invnode.animateList(false);
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/newdash.fxml"));
		Scene scene = new Scene(root);
	
		Stage stage = new Stage();
		 stage.initModality(Modality.APPLICATION_MODAL);
		 stage.setTitle("Apro Billing Software:: Version 1.0"); 
		   stage.initStyle(StageStyle.UTILITY);
		   stage.setScene(scene);
		   stage.setResizable(false);
		   stage.show();
	}
	public void ondefault(ActionEvent e)
	{
		
	}
	public void oninv(ActionEvent e) throws IOException
	{
		invnode.animateList(false);
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Invoices/newinvoice.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		 stage.initModality(Modality.APPLICATION_MODAL);
		 stage.setTitle("Apro Billing Software:: Version 1.0"); 
		   stage.initStyle(StageStyle.UTILITY);
		   stage.setScene(scene);
		   stage.setResizable(false);
		   stage.show();
	}
	@Override
	public void start(Stage stage) throws Exception{
	   
	}
}
