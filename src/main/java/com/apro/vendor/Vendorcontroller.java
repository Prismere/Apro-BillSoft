package com.apro.vendor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.apro.comfun.Functions;
import com.apro.login.SqliteConnection;
import com.jfoenix.controls.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Vendorcontroller {
	Connection conn;
	public Vendorcontroller() {
		conn = SqliteConnection.Connector();
		}
	@FXML
	Button btncan = new Button();
	@FXML
	JFXTextField vname = new JFXTextField();
	@FXML
	JFXTextField vemail = new JFXTextField();
	@FXML
	JFXTextField vphone = new JFXTextField();
	@FXML
	JFXTextField vpan = new JFXTextField();
	@FXML
	JFXTextField vgst = new JFXTextField();
	@FXML
	JFXTextField vtin = new JFXTextField();
	@FXML
	JFXTextField vcode = new JFXTextField();
	@FXML
	JFXTextArea vaddress = new JFXTextArea();

	public void vensave(ActionEvent e) throws SQLException
	{
		String que = "insert into vendor (vname,vemail,vphone,vaddress,vtin,vgst,vpan,vcode,status) values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(que);
		String venname = vname.getText();
		String venemail = vemail.getText();
		String venphone = vphone.getText();
		String venpan = vpan.getText();
		String vengst = vgst.getText();
		String ventin = vtin.getText();
		String vencode = vcode.getText();
		String venaddress = vaddress.getText();
		String venstatus = "1";
		try {
			stmt.setString(1, venname);
			stmt.setString(2, venemail);
			stmt.setString(3, venphone);
			stmt.setString(4, venaddress);
			stmt.setString(5, ventin);
			stmt.setString(6, vengst);
			stmt.setString(7, venpan);
			stmt.setString(8, vencode);
			stmt.setString(9, venstatus);
			stmt.executeUpdate();
			Functions.invsave(vname.getText() + " successfully inserted");
		}
		catch(SQLException e1)
		{
			
			Functions.invsave(e1.getMessage());
		}
		finally
		{
			stmt.close();
		}
	}
	public void vencancel (ActionEvent e)
	{    
		Stage stg = (Stage) btncan.getScene().getWindow();
		stg.close();
	}
	public void onview(ActionEvent e) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Vendor/vendorsearch.fxml"));
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
