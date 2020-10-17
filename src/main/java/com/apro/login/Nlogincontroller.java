package com.apro.login;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.apro.comfun.Functions;
import com.jfoenix.controls.*;

import animatefx.animation.BounceIn;
import animatefx.animation.FadeOut;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Nlogincontroller implements Initializable{
@FXML
JFXToggleButton tg;
@FXML
JFXPasswordField pfield;
@FXML
JFXTextField ptext,txtname;
@FXML
Label lblerror = new Label();
@FXML
JFXButton btnlog;
public SqliteConnection loginc = new SqliteConnection();
@FXML
JFXProgressBar jfx= new JFXProgressBar();
@FXML
HBox logbox = new HBox();
@Override
public void initialize(URL location, ResourceBundle resources) {
	if (loginc.isDbConnected())
		System.out.println("Database is connected");
	else
		Functions.invsave("Database is not connected");
	ptext.setVisible(false);
	lblerror.setVisible(false);
	tg.setFocusTraversable(false);
}

public void ontoggle(ActionEvent eve)
{
	if(tg.isSelected())
	{
		ptext.setVisible(true);
		ptext.setText(pfield.getText());
		pfield.setVisible(false);
		ptext.requestFocus();
		ptext.positionCaret(100);
		
	}
	else
	{
		ptext.setVisible(false);
		pfield.setText(ptext.getText());
		pfield.setVisible(true);
		pfield.requestFocus();
		pfield.positionCaret(100);
	}
}

public void onlog(ActionEvent eve)
{
	
	try {
		if (loginc.isLogin(txtname.getText(), pfield.getText())) {		
			try {
				Stage stage1 = (Stage) btnlog.getScene().getWindow();
				stage1.close();
				Parent root = FXMLLoader.load(getClass().getResource("/fxml/newdash.fxml"));
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				scene.getStylesheets().add("/styles/main.css");
				stage.setTitle("Apro Billing Software:: Version 1.0"); 
				stage.setScene(scene);
				stage.setResizable(false);
				stage.show();
			} catch (Exception e) {
				Functions.invsave(e.getMessage());
			}
		} else
		{
			lblerror.setVisible(true);
		new BounceIn(lblerror).play();
		}
		} catch (SQLException e) {
		Functions.invsave(e.getMessage());
	}
}



public void onenter(ActionEvent e)
{
	try {
		if(tg.isSelected())
		{
			pfield.setText(ptext.getText());
			if (loginc.isLogin(txtname.getText(), pfield.getText())) {		
			try {
				Stage stage1 = (Stage) btnlog.getScene().getWindow();
				stage1.close();
				Parent root = FXMLLoader.load(getClass().getResource("/fxml/newdash.fxml"));
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				scene.getStylesheets().add("/styles/main.css");
				stage.setTitle("Apro Billing Software:: Version 1.0"); 
				stage.setScene(scene);
				stage.setResizable(false);
				stage.show();
			} catch (Exception es) {
				Functions.invsave(es.getMessage());
			}
		} else
		{
			lblerror.setVisible(true);
			new BounceIn(lblerror).play();
		}
		}
		else
		{
			ptext.setText(pfield.getText());
			if (loginc.isLogin(txtname.getText(), ptext.getText())) {		
			try {
				Stage stage1 = (Stage) btnlog.getScene().getWindow();
				stage1.close();
				Parent root = FXMLLoader.load(getClass().getResource("/fxml/newdash.fxml"));
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				scene.getStylesheets().add("/styles/main.css");
				stage.setTitle("Apro Billing Software:: Version 1.0"); 
				stage.setScene(scene);
				stage.setResizable(false);
				stage.show();
			} catch (Exception es) {
				Functions.invsave(es.getMessage());
			}
		} else
		{
			new BounceIn(lblerror).play();lblerror.setVisible(true);
		}
			
		}
	}
	catch (SQLException ex) {
		Functions.invsave(ex.getMessage());
	}
}
}
