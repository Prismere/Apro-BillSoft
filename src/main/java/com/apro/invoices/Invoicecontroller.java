package com.apro.invoices;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import com.apro.comfun.Functions;
import com.apro.homescreen.NewMainController;
import com.apro.login.SqliteConnection;
import com.apro.purchase.Purmodel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;


import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
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

public class Invoicecontroller implements Initializable {
	Connection conn;
	Boolean b;
	 public Invoicecontroller() {
		 
		 conn = SqliteConnection.Connector(); 
		 }
		
	 @FXML
		JFXTextArea itemdesc = new JFXTextArea();
	
	 @FXML
		JFXTextField qty = new JFXTextField();
	@FXML
	JFXButton btnadd = new JFXButton();
@FXML
Button btncancel = new Button();
@FXML
Label txtsub = new Label();
@FXML
Label txtgst = new Label();
@FXML
Label txttot=new Label();
@FXML
Label txtdis = new Label();
@FXML
JFXComboBox<String> cmbpro;
@FXML
JFXComboBox<String> cmbclient;
@FXML
TextField tax = new TextField();
@FXML
Label dtpick = new Label();
@FXML
JFXComboBox<String> cmbpay;
@FXML
TableView<Purmodel> tblpro;
@FXML
Label lblinvno = new Label();
@FXML
TableColumn<Purmodel, String> name;
ObservableList<Purmodel> obist = FXCollections.observableArrayList();

private List<String> getclient() {
	// Define the data you will be returning, in this case, a List of Strings for
	// the ComboBox
	List<String> options = new ArrayList<>();
	try {
		String query = "select name from client order by name ASC";
		PreparedStatement statement = conn.prepareStatement(query);

		ResultSet set = statement.executeQuery();
		while (set.next()) {
			options.add(set.getString("name"));
		}
		statement.close();
		set.close();
		return options;
	} catch (SQLException ex) {
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
		/* Functions.invsave(ex.getMessage()); */
		return null;
	}

}



public void oncan(ActionEvent event)
{
	Stage stage = (Stage) btncancel.getScene().getWindow();
	stage.close();
}

public void onnew(ActionEvent ex)
{
	
	Scene scene= (Scene) btnadd.getScene();
	String s = scene.getStylesheets().toString();
	try
	{
	Parent root = FXMLLoader.load(getClass().getResource("/fxml/Clients/newclient.fxml"));
	scene = new Scene(root);
	
	Stage stage = new Stage();
	stage.setTitle("Inventory:: Version 1.0"); 
	stage.initModality(Modality.APPLICATION_MODAL);
	stage.initStyle(StageStyle.UTILITY);
	
	 if(s.equals("[/styles/Dark.css]"))
		{
	   scene.getStylesheets().add("/styles/Dark.css");
	
	stage.setScene(scene);
	stage.setResizable(false);
	stage.show();
		}
	 else
	 {
		 scene.getStylesheets().add("/styles/main.css");
			
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
	 }
	}
	catch (Exception exx) {
		Functions.invsave(exx.getMessage());
}
}

public void saveinvoice(ActionEvent e)
{
	
	try
	{
	
	Parent root = FXMLLoader.load(getClass().getResource("/fxml/Report/prodbill.fxml"));
	Scene scene = new Scene(root);
	Stage stage = new Stage();
	stage.setTitle("Inventory:: Version 1.0"); 
	
	/* make only foreground window active*/
	
	stage.initModality(Modality.APPLICATION_MODAL);
	
	stage.initStyle(StageStyle.UTILITY);
	
	
	stage.setScene(scene);
	/* stage.setMaximized(true); */
	stage.show();
} catch (Exception e2) {
	Functions.invsave(e2.getMessage());
}
}

@Override
public void initialize(URL location, ResourceBundle resources) {
	cmbclient.setItems(FXCollections.observableArrayList(getclient()));
	cmbclient.setEditable(true);
	TextFields.bindAutoCompletion(cmbclient.getEditor(), cmbclient.getItems());
	
	cmbpro.setItems(FXCollections.observableArrayList(getProduct()));
	cmbpro.setEditable(true);
	TextFields.bindAutoCompletion(cmbpro.getEditor(), cmbpro.getItems());
	
	
	
	String timeStamp = new SimpleDateFormat("dd" + "/" + "MM" + "/" +"yyyy").format(Calendar.getInstance().getTime());
	dtpick.setText(timeStamp);
	cmbpay.getItems().addAll("Credit Card","Debit Card","UPI","Cash","Pay Later");
	
	
	try
	{
		PreparedStatement stmt = conn.prepareStatement("select id from tbcat order by id desc limit 1");
		ResultSet set = stmt.executeQuery();
		lblinvno.setText(set.getString("id"));
		set.close();
		stmt.close();
	}
	catch(SQLException ex)
	{
		Functions.invsave(ex.getMessage());
	}	
}
public void selecteditem(ActionEvent ex) throws SQLException
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
		e.getMessage();
	}
	finally
	{
		fetchproduct.close();
		items.close();
	}
}
int c = 0;
public void onadd(ActionEvent e)
{	
	c++;
	obist.add(new Purmodel("1"));
	name.setCellValueFactory(new PropertyValueFactory<>("name"));
	tblpro.setItems(obist);
	txttot.setText(String.valueOf(c));
}


public void ad(boolean selected) {

	
}

}
