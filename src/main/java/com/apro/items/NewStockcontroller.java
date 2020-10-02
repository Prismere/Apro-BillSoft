package com.apro.items;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.apro.comfun.Functions;
import com.apro.login.SqliteConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;

import javafx.beans.value.ObservableValue;
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

public class NewStockcontroller implements Initializable{
	
	Connection conn;
	public NewStockcontroller()
	{
		 conn = SqliteConnection.Connector(); 
	}
	
	
	ObservableList<Newitemstockmodel> obist = FXCollections.observableArrayList();
	@FXML
	TableView <Newitemstockmodel> tblstock;
	@FXML
	TableColumn<Newitemstockmodel, String> id;
	@FXML
	TableColumn<Newitemstockmodel, String> iname;
	@Override
	public void initialize(URL location, ResourceBundle resources){
		ResultSet rs = null;
		try {
			 rs = conn.createStatement().executeQuery("select * from item");
			while (rs.next())
			{
				obist.add(new Newitemstockmodel(rs.getString("id"), rs.getString("iname")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Functions.invsave(e.getMessage());
		}
		
		
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		iname.setCellValueFactory(new PropertyValueFactory<>("iname"));
		tblstock.setItems(obist);
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
		            Newitemstockmodel item= tblstock.getSelectionModel().getSelectedItem();
		   		 tblstock.getItems().remove(item);
		   		 String qu ="delete from item where id = " + item.id + ";";
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
}
