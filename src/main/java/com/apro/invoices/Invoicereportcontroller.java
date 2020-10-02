package com.apro.invoices;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.apro.login.SqliteConnection;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;


public class Invoicereportcontroller implements Initializable
{
	Connection conn;
	public Invoicereportcontroller() {
		conn = SqliteConnection.Connector();
	}
	
	
	
	
	@FXML
	TableView<Invoicemodel> tableview;
	@FXML
	TableColumn<Invoicemodel, String> id;
	@FXML
	TableColumn<Invoicemodel, String> catname;
	
	

	
	ObservableList<Invoicemodel> obist = FXCollections.observableArrayList();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try
		{
		ResultSet rs = conn.createStatement().executeQuery("select * from tbcat");
		while(rs.next())
		{
			obist.add(new Invoicemodel(rs.getString("id"),rs.getString("catname")));
		}
		}
		catch (SQLException ex)
		{
			System.out.println("Error");
		}
		
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		catname.setCellValueFactory(new PropertyValueFactory<>("catname"));
		tableview.setItems(obist);
	}
}
