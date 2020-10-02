package com.apro.login;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController implements Initializable {
	@FXML
	TextField passtext = new TextField();
	@FXML
	Button signin = new Button();
	@FXML
	TextField usrname = new TextField();
	@FXML
	PasswordField pfpass = new PasswordField();
	@FXML
	Label inco = new Label();
	@FXML
	CheckBox toggle = new CheckBox();

	public void logincancel(ActionEvent event) {
		Platform.exit(); 
	}
	@FXML
	public void showpass(MouseEvent event)
	{
		passtext.setText(pfpass.getText());
		passtext.setVisible(true);
		System.out.println(pfpass.getText());
	}
	public void removepass(MouseEvent eve)
	{
		passtext.setVisible(false);
	}
	public void show(ActionEvent event)
	{
		if(toggle.isSelected())
		{
			passtext.setText(pfpass.getText());
			passtext.setVisible(true);
		}
		else
		{
		pfpass.setText(passtext.getText());
		passtext.setVisible(false);
		}
	}
/* Enter key pressing on text field */
	@FXML
	public void passenter(ActionEvent event)
	{
			try {
			if (loginc.isLogin(usrname.getText(), pfpass.getText())) {
				try {
					Stage stage1 = (Stage) signin.getScene().getWindow();
					stage1.close();
					Parent root = FXMLLoader.load(getClass().getResource("/fxml/newdash.fxml"));
					Scene scene = new Scene(root);
					Stage stage = new Stage();
					stage.setTitle("Apro Billing Software:: Version 1.0");
					stage.setScene(scene);
					stage.setMaximized(true);
					stage.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else
				inco.setText("Incorrect Username or Password");
		} catch (SQLException e) {
			inco.setText("Incorrect Username or Password");
			e.printStackTrace();
		}
	}
	@FXML
	public void unameenter(ActionEvent event)
	{
			try {
			if (loginc.isLogin(usrname.getText(), pfpass.getText())) {
				
				try {
					Stage stage1 = (Stage) signin.getScene().getWindow();
					stage1.close();
					Parent root = FXMLLoader.load(getClass().getResource("/fxml/newdash.fxml"));
					Scene scene = new Scene(root);
					Stage stage = new Stage();
					stage.setTitle("Apro Billing Software:: Version 1.0");
					stage.setScene(scene);
					stage.setMaximized(true);
					stage.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else
				inco.setText("Incorrect Username or Password");
		} catch (SQLException e) {
			inco.setText("Incorrect Username or Password");
			e.printStackTrace();
		}
	}
	@FXML
	public void onsignin(ActionEvent event) {
		try {
			if (loginc.isLogin(usrname.getText(), pfpass.getText())) {		
				try {
					Stage stage1 = (Stage) signin.getScene().getWindow();
					stage1.close();
					Parent root = FXMLLoader.load(getClass().getResource("/fxml/newdash.fxml"));
					Scene scene = new Scene(root);
					Stage stage = new Stage();
					stage.setTitle("Apro Billing Software:: Version 1.0"); 
					stage.setScene(scene);
					stage.setMaximized(true);
					stage.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else
				inco.setText("Incorrect Username or Password");
		} catch (SQLException e) {
			inco.setText("Incorrect Username or Password");
			e.printStackTrace();
		}
	}
	public SqliteConnection loginc = new SqliteConnection();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (loginc.isDbConnected())
			inco.setText("");
		else
			inco.setText("Database Not Connected");
	}
}
