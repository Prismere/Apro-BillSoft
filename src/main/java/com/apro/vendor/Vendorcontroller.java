package com.apro.vendor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.apro.login.SqliteConnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Vendorcontroller {
	
	Connection conn;

	public Vendorcontroller() {
		conn = SqliteConnection.Connector();
		if (conn == null) {
			System.out.println("Connection Not Successful");

			System.exit(1);
		}
	}

	

	/*
	 * String qq = "Delete from item"; PreparedStatement qqq =
	 * conn.prepareStatement("delete from item"); qqq.executeUpdate();
	 */
	
	
	
	
	public boolean isDbConnected() {
		try {
			return !conn.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static Connection Connector() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn1 = DriverManager.getConnection("jdbc:sqlite:testdb.sqlite");
			return conn1;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	
	
	@FXML
	Button btncan = new Button();
	@FXML
	TextField vname = new TextField();
	@FXML
	TextField vemail = new TextField();
	@FXML
	TextField vphone = new TextField();
	@FXML
	TextField vpan = new TextField();
	@FXML
	TextField vgst = new TextField();
	@FXML
	TextField vtin = new TextField();
	@FXML
	TextField vcode = new TextField();
	@FXML
	TextArea vaddress = new TextArea();
	@FXML
	Label lblmsg = new Label();
	
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
			lblmsg.setText(venname + "Inserted Successfully;");
			
		}
		catch(SQLException e1)
		{
			lblmsg.setText("Error in Insertion");
			e1.printStackTrace();
		}
	}
	
	
	
	public void vencancel (ActionEvent e)
	{
		
	    try {
			PreparedStatement delven = conn.prepareStatement("delete from vendor");
			delven.executeUpdate();
			delven.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	    
		Stage stg = (Stage) btncan.getScene().getWindow();
		stg.close();
	}
	
	
	
}
