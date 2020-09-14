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
	@FXML
	TableView<Invoicemodel> tableview;
	@FXML
	TableColumn<Invoicemodel, String> id;
	@FXML
	TableColumn<Invoicemodel, String> catname;
	
	Connection conn;

	public Invoicereportcontroller() {
		conn = SqliteConnection.Connector();
		if (conn == null) {
			System.out.println("Connection Not Successful");

			System.exit(1);
		}
	}

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
