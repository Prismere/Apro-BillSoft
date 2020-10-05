package com.apro.purchase;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import com.apro.category.Catmodel;
import com.apro.comfun.Functions;
import com.apro.login.SqliteConnection;
import com.jfoenix.controls.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PurchaseController implements Initializable{
	
	@FXML
	JFXComboBox<String> cmbvendor = new JFXComboBox<String>();
	@FXML
	JFXButton btncancel = new JFXButton();
	@FXML
	JFXComboBox<String> cmbpro = new JFXComboBox<String>();
	@FXML
	JFXTextArea itemdesc = new JFXTextArea();
	@FXML
	JFXTextField qty = new JFXTextField();
	@FXML
	TextField up = new TextField();
	@FXML
	TextField disc = new TextField();
	@FXML
	TextField tax = new TextField();
	@FXML
	Label dtpick = new Label();
	@FXML
	JFXComboBox<String> cmbpay = new JFXComboBox<String>();
	@FXML
	TableView<Purmodel> tblpro;

	@FXML
	TableColumn<Purmodel, String> name;
	Connection conn;
	ObservableList<Purmodel> obist = FXCollections.observableArrayList();
	 public PurchaseController() {
		 
		 conn = SqliteConnection.Connector(); 
		 }
			@Override
			public void initialize(URL location, ResourceBundle resources) {
				// TODO Auto-generated method stub
				
				
				cmbvendor.setItems(FXCollections.observableArrayList(getvendor()));
				cmbvendor.setEditable(true);
				TextFields.bindAutoCompletion(cmbvendor.getEditor(), cmbvendor.getItems());
				
			
				cmbpro.setItems(FXCollections.observableArrayList(getProduct()));
				cmbpro.setEditable(true);
				TextFields.bindAutoCompletion(cmbpro.getEditor(), cmbpro.getItems());
				
				String timeStamp = new SimpleDateFormat("dd" + "/" + "MM" + "/" +"yyyy").format(Calendar.getInstance().getTime());
				dtpick.setText(timeStamp);
				cmbpay.getItems().addAll("Credit Card","Debit Card","UPI","Cash","Pay Later");
				
				
			}

			


private List<String> getvendor(){
	
	List<String> vendors = new ArrayList<>();
	
	try {
		
		String query = "select vname from vendor order by vname ASC";
		PreparedStatement statement = conn.prepareStatement(query);

		ResultSet set = statement.executeQuery();
		while (set.next()) {
			vendors.add(set.getString("vname"));
		}
		statement.close();
		set.close();
		return vendors;
		
	}
	catch(SQLException ex) {
		Functions.invsave(ex.getMessage());
		return null;
	}
	
}

private List<String> getProduct(){
	
	List<String> items = new ArrayList<>();
	ResultSet set = null;
	try {
		
		String query = "select iname from item order by iname ASC";
		PreparedStatement statement = conn.prepareStatement(query);

		set = statement.executeQuery();
		while (set.next()) {
			items.add(set.getString("iname"));
		}
		statement.close();
		set.close();
		return items;
		
	}
	catch(SQLException ex) {
		Functions.invsave(ex.getMessage());
		return null;
	}

}
	
public void selecteditem(ActionEvent ev) throws SQLException
{
	
	ResultSet items = null;
	PreparedStatement fetchproduct = null;
	String query = "select * from item where iname = '"+ cmbpro.getValue().toString() +"';";
	try {
		fetchproduct = conn.prepareStatement(query);
	    items = fetchproduct.executeQuery();
	    
	    itemdesc.setText(items.getString("desc"));
	    qty.setText("1");
	    
	    qty.requestFocus();
	} 
	
	catch (SQLException e) {
		// TODO Auto-generated catch block
		Functions.invsave(e.getMessage());
	}
	finally
	{
		fetchproduct.close();
		items.close();
	}
	
	
}
public void onnew(ActionEvent e) throws IOException
{
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
public void oncan(ActionEvent e)
{
	Stage stage = (Stage) btncancel.getScene().getWindow();
	stage.close();
}
public void onadd(ActionEvent e)
{
	obist.add(new Purmodel("hii"));
	name.setCellValueFactory(new PropertyValueFactory<>("name"));
	tblpro.setItems(obist);
}
}

