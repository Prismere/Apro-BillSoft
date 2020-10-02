package com.apro.client;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.apro.comfun.Functions;
import com.apro.login.SqliteConnection;
import com.apro.vendor.Venmodel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Clientsearchcontroller implements Initializable{
	Connection conn;
	public Clientsearchcontroller()
	{
		conn=SqliteConnection.Connector();
	}
	
	ObservableList<Clientmodel> obist = FXCollections.observableArrayList();
	@FXML
	TableView<Clientmodel> tblcli;
	@FXML
	TableColumn<Clientmodel, String> id;
	@FXML
	TableColumn<Clientmodel, String> name;
	@FXML
	TableColumn<Clientmodel, String> email;
	@FXML
	TableColumn<Clientmodel, String> phone;
	@FXML
	TableColumn<Clientmodel, String> address;
	@FXML
	TableColumn<Clientmodel, String> status;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 ResultSet rs = null;
		try {
			 rs = conn.createStatement().executeQuery("select * from client");
			while (rs.next())
			{
				obist.add(new Clientmodel(rs.getString("id"), rs.getString("name"), rs.getString("email"), rs.getString("phone"), rs.getString("address"), rs.getString("status")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Functions.invsave(e.getMessage());
		}
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		email.setCellValueFactory(new PropertyValueFactory<>("email"));
		phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		address.setCellValueFactory(new PropertyValueFactory<>("address"));
		status.setCellValueFactory(new PropertyValueFactory<>("status"));
		tblcli.setItems(obist);
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Functions.invsave(e.getMessage());
		}
	}
	public void prodel(ActionEvent e) throws SQLException
	{ 	  
		  Stage primaryStage = new Stage();
			 JFXDialogLayout content= new JFXDialogLayout();		    
			    content.setBody(new Text("Confirm Delete"));
			    StackPane stackpane = new StackPane();
			    JFXDialog dialog =new JFXDialog(stackpane, content, JFXDialog.DialogTransition.CENTER);
			    JFXButton button=new JFXButton("Delete");
			    JFXButton button1 = new JFXButton("Cancel");
			    button.setOnAction(new EventHandler<ActionEvent>(){
			        @Override
			        public void handle(ActionEvent event){
			            dialog.close();  
			            Clientmodel item= tblcli.getSelectionModel().getSelectedItem();
			            tblcli.getItems().remove(item);
			   		 String qu ="delete from client where id = " + item.id + ";";
			   		  PreparedStatement pe;
					try {
						pe = conn.prepareStatement(qu);
						pe.executeUpdate();
						pe.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					primaryStage.close();
			        }
			    });
			    button1.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						primaryStage.close();
					}
				});   
			    content.setActions(button,button1);
			    Scene scene = new Scene(stackpane);
			    primaryStage.initModality(Modality.APPLICATION_MODAL);
			    primaryStage.setTitle("Apro Billing Software:: Version 1.0"); 
			    primaryStage.initStyle(StageStyle.UTILITY);
			    primaryStage.setScene(scene);
			    dialog.show();
			    primaryStage.setResizable(false);
			    primaryStage.show();
	}
	@FXML
	JFXButton btncan = new JFXButton();
	public void oncan(ActionEvent e)
	{
		Stage stage = (Stage) btncan.getScene().getWindow();
		stage.close();
	}
}
