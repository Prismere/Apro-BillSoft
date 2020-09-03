package com.apro.login;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import org.apache.commons.validator.routines.EmailValidator;
import org.sqlite.SQLiteConnection;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginController implements Initializable {

	@FXML
	Button signin = new Button();
	@FXML
	TextField usrname = new TextField();
	@FXML
	PasswordField pfpass = new PasswordField();
	@FXML
	Label inco = new Label();

	public void logincancel(ActionEvent event) {
		/*
		 * // EmailValidator usrval = EmailValidator.getInstance(); //
		 * System.out.println(usrname.getText()); // // if
		 * (usrval.isValid(usrname.getText())) { //
		 * System.out.println("Email is valid"); // } else { //
		 * inco.setText("Incorrect Email or Password"); //
		 * System.out.println("Email is invalid"); // }
		 */		 
		Platform.exit(); 
	}
	
	
/* Enter key pressing on text field */
	@FXML
	public void passenter(ActionEvent event)
	{
			try {
			if (loginc.isLogin(usrname.getText(), pfpass.getText())) {
				
				try {
					Window window = signin.getScene().getWindow();
					Stage stage1 = (Stage) signin.getScene().getWindow();
					stage1.close();
					Parent root = FXMLLoader.load(getClass().getResource("/fxml/aa.fxml"));
					Scene scene = new Scene(root);
					Stage stage = new Stage();
					stage.setTitle("Inventory:: Version 1.0"); /*
																 * stage.getIcons().add(new Image("/images/logo.png"));
																 * stage.initStyle(StageStyle.UNDECORATED);
																 */
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
					Window window = signin.getScene().getWindow();
					Stage stage1 = (Stage) signin.getScene().getWindow();
					stage1.close();
					Parent root = FXMLLoader.load(getClass().getResource("/fxml/aa.fxml"));
					Scene scene = new Scene(root);
					Stage stage = new Stage();
					stage.setTitle("Inventory:: Version 1.0"); /*
																 * stage.getIcons().add(new Image("/images/logo.png"));
																 * stage.initStyle(StageStyle.UNDECORATED);
																 */
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

		/*
		 * try { Window window = signin.getScene().getWindow(); Stage stage1 = (Stage)
		 * signin.getScene().getWindow(); stage1.close(); Parent root =
		 * FXMLLoader.load(getClass().getResource("/fxml/aa.fxml")); Scene scene = new
		 * Scene(root); Stage stage = new Stage();
		 * stage.setTitle("Inventory:: Version 1.0"); stage.getIcons().add(new
		 * Image("/images/logo.png")); stage.initStyle(StageStyle.UNDECORATED);
		 * stage.setScene(scene); stage.setMaximized(true); stage.show(); } catch
		 * (Exception e) { e.printStackTrace(); }
		 */

		try {
			
			if (loginc.isLogin(usrname.getText(), pfpass.getText())) {
				
				try {
					Window window = signin.getScene().getWindow();
					Stage stage1 = (Stage) signin.getScene().getWindow();
					stage1.close();
					Parent root = FXMLLoader.load(getClass().getResource("/fxml/aa.fxml"));
					Scene scene = new Scene(root);
					Stage stage = new Stage();
					stage.setTitle("Inventory:: Version 1.0"); /*
																 * stage.getIcons().add(new Image("/images/logo.png"));
																 * stage.initStyle(StageStyle.UNDECORATED);
																 */
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
