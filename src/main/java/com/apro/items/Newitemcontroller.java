package com.apro.items;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import com.apro.comfun.*;
import com.apro.login.SqliteConnection;

public class Newitemcontroller implements Initializable{
@FXML
private StackPane stackpane;
@FXML
JFXTextField pname,pprice,psale,pmin,pmrp,psku,phsn,pcgst,pigst,psgst,pcess;
@FXML
JFXTextArea pdes;
@FXML
JFXComboBox<String> cmbbrand,cmbcat;
PreparedStatement statement = null;
PreparedStatement statement1 = null;
PreparedStatement preps = null;
PreparedStatement stocks=null;
	Connection conn;
	public Newitemcontroller()
	{
		conn=SqliteConnection.Connector();
	}
	public void onsave(ActionEvent e) throws SQLException
	{
		String category = null;
		String brand = null; 
		String a = cmbcat.getSelectionModel().getSelectedItem();
		String query = "select id from tbcat where catname = " + "'"+a+"'";
		System.out.println(query);
		PreparedStatement pp = conn.prepareStatement(query);
		ResultSet rs = pp.executeQuery();
		if(rs.next())
		{
			category = rs.getString("id");
			
		}
		String c = cmbbrand.getSelectionModel().getSelectedItem();
		String query1 = "select id from brand where brandname = " + "'"+c+"'";
		System.out.println(query1);
		PreparedStatement pp1 = conn.prepareStatement(query1);
		ResultSet rs1 = pp1.executeQuery();
		if(rs1.next())
		{
			brand = rs1.getString("id");
		}
		try
		{
		String q = "insert into item (iname,catid,bid,sku,desc,hsn,cgst,sgst,igst,cess) values (?,?,?,?,?,?,?,?,?,?);";
		String query2 = "insert into stock (itemid,purprice,saleprice,minprice,mrp,purstock,stockvalue,curstock) values (?,?,?,?,?,?,?,?);";
		 preps=conn.prepareStatement(q);
		 stocks = conn.prepareStatement(query2);
		preps.setString(1, pname.getText());
		preps.setString(2, category);
		preps.setString(3, brand);
		preps.setString(4, psku.getText());
		preps.setString(5, pdes.getText());
		preps.setString(6, phsn.getText());
		preps.setString(7, pcgst.getText());
		preps.setString(8, psgst.getText());
		preps.setString(9, pigst.getText());
		preps.setString(10, pcess.getText());
		preps.executeUpdate();
		ResultSet keys = preps.getGeneratedKeys(); 
		keys.next(); 
		int key = keys.getInt(1);
		System.out.print(key);
		stocks.setInt(1, key);
		stocks.setString(2, pprice.getText());
		stocks.setString(3, "39.3");
		stocks.setString(4, "39.3");
		stocks.setString(5, "39.3");
		stocks.setString(6, "39.3");
		stocks.setString(7, "39");
		int aa = 7 * 3;
		stocks.setString(7, String.valueOf(aa));
		stocks.executeUpdate();
		}
		catch(SQLException ex)
		{
		Functions.invsave("Error in database function");
		}
		
		finally
		{
			rs.close();
			rs1.close();
			preps.close();
			stocks.close();	
		}
		Functions.invsave(pname.getText() + " is inserted");
		pname.setText(null);
		pprice.setText(null);
		psale.setText(null);
		pmin.setText(null);
		pmrp.setText(null);
		psku.setText(null);
		phsn.setText(null);
		pcgst.setText(null);
		pigst.setText(null);
		psgst.setText(null);
		pcess.setText(null);
	}
	
	private List<String> getbrand() {
		// Define the data you will be returning, in this case, a List of Strings for
		// the ComboBox
		List<String> options = new ArrayList<>();
		try {
		
			String query = "select brandname from brand order by brandname ASC";
			PreparedStatement statement = conn.prepareStatement(query);

			ResultSet set = statement.executeQuery();
			while (set.next()) {
				options.add(set.getString("brandname"));
			}
			statement.close();
			set.close();
			return options;
		} catch (SQLException ex) {
			return null;
		}
	}

	private List<String> getData() {
		// Define the data you will be returning, in this case, a List of Strings for
		// the ComboBox
		List<String> options = new ArrayList<>();
		try {
			String query = "select catname from tbcat order by catname ASC";
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				options.add(set.getString("catname"));
			}
			statement.close();
			set.close();
			// Return the List
			return options;
		} catch (SQLException ex) {
			return null;
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cmbcat.setItems(FXCollections.observableArrayList(getData()));
		cmbcat.setEditable(true);
		TextFields.bindAutoCompletion(cmbcat.getEditor(), cmbcat.getItems());
		cmbbrand.setItems(FXCollections.observableArrayList(getbrand()));
		cmbbrand.setEditable(true);
		TextFields.bindAutoCompletion(cmbbrand.getEditor(), cmbbrand.getItems());
	}
}
