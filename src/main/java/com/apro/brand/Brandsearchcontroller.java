package com.apro.brand;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.apro.category.Catmodel;
import com.apro.comfun.Functions;
import com.apro.items.Newitemstockmodel;
import com.apro.login.SqliteConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Brandsearchcontroller implements Initializable{
Connection conn;
PreparedStatement p = null;
public Brandsearchcontroller()
{
	conn=SqliteConnection.Connector();
}
ObservableList<Brandsearchmodel> obist = FXCollections.observableArrayList();
@FXML
TableView<Brandsearchmodel> tblbrand;
@FXML
TableColumn<Brandsearchmodel, String> id;
@FXML
TableColumn<Brandsearchmodel, String> brandname;
@FXML
JFXButton ref;


public void onrefresh(ActionEvent eve) throws IOException
{
	Stage stage1 = (Stage) ref.getScene().getWindow();
	stage1.close();
	Scene scene1 = (Scene) ref.getScene();
	String s = scene1.getStylesheets().toString();
	
	Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/brandsearch.fxml"));
	Scene scene = new Scene(root);
	Stage stage = new Stage();
	stage.setTitle("Apro Billing Software:: Version 1.0"); 
	if(s.equals("[/styles/Dark.css]"))
	{
		scene.getStylesheets().add("/styles/Dark.css");
		
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();	
	}
	else
	{
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
}


@Override
public void initialize(URL location, ResourceBundle resources) {
	 ResultSet rs = null;
	try {
		 rs = conn.createStatement().executeQuery("select * from brand order by brandname");
		while (rs.next())
		{
			obist.add(new Brandsearchmodel(rs.getString("id"), rs.getString("brandname")));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		Functions.invsave(e.getMessage());
	}
	
	
	id.setCellValueFactory(new PropertyValueFactory<>("id"));
	brandname.setCellValueFactory(new PropertyValueFactory<>("brandname"));
	tblbrand.setItems(obist);
	try {
		rs.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		Functions.invsave(e.getMessage());
	}
	
	
	tblbrand.setRowFactory( tv -> {
	    TableRow<Brandsearchmodel> row = new TableRow<>();
	    row.setOnMouseClicked(eve -> {
	        if (eve.getClickCount() == 2 && (! row.isEmpty()) ) {
	        	Stage stage = new Stage();
	        	JFXDialogLayout content = new JFXDialogLayout();
	        	content.setBody(new Text("Confirm the changes"));
	        	StackPane stackpane = new StackPane();
	        	JFXDialog dialog =new
	        	JFXDialog(stackpane, content, JFXDialog.DialogTransition.CENTER); 
	        	JFXButton button=new JFXButton("Update"); 
	        	JFXButton button1 = new JFXButton("Cancel");
	        	JFXTextField txted = new JFXTextField();
	        	txted.setPromptText("Enter new value");
	        	txted.setLabelFloat(true);
	        	button.setOnAction(new EventHandler<ActionEvent>() {
	        		
					@Override
					public void handle(ActionEvent event) {
						
						Brandsearchmodel rowData = row.getItem();
			            
			            String query = "update brand set brandname = ? where id=" + rowData.getId() +";";	
			            try {
							p = conn.prepareStatement(query);
							p.setString(1, txted.getText().toString().toUpperCase());
							p.execute();
							p.close();
							
							try {
								onrefresh(event);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						} catch (SQLException e) {
							Functions.invsave(e.getMessage());
						}
						dialog.close();
						stage.close();
						
					}
	        		
				});
	        	txted.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						Brandsearchmodel rowData = row.getItem();
			            
			            String query = "update brand set brandname = ? where id=" + rowData.getId() +";";	
			            try {
							p = conn.prepareStatement(query);
							p.setString(1, txted.getText().toString().toUpperCase());
							p.execute();
							p.close();
							try {
								onrefresh(event);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} catch (SQLException e) {
							Functions.invsave(e.getMessage());
						}
						dialog.close();
						stage.close();
					}
				});
	        	button1.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						dialog.close();
						stage.close();
						
					}
				});
	        	content.setActions(txted,button,button1);
	        	Scene scene = new Scene (stackpane);
	        	stage.initModality(Modality.APPLICATION_MODAL);
	        	stage.setScene(scene);
	        	dialog.show();
	        	stage.show();     
	        }
	    });
	    return row ; 
	});
	
	
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
		            Brandsearchmodel item= tblbrand.getSelectionModel().getSelectedItem();
		       	 tblbrand.getItems().remove(item);
		   		 String qu ="delete from brand where id = " + item.id + ";";
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
