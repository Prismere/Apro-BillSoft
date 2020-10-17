package com.apro.category;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.springframework.context.annotation.Primary;

import com.apro.brand.Brandsearchmodel;
import com.apro.comfun.Functions;
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

public class Catsearchcontroller implements Initializable{
	Connection conn;
	PreparedStatement p = null;
	public Catsearchcontroller()
	{
	conn=SqliteConnection.Connector();
	}
	ObservableList<Catmodel> obist = FXCollections.observableArrayList();
	@FXML
	TableView<Catmodel> tblcat;
	@FXML
	TableColumn<Catmodel, String> id;
	@FXML
	TableColumn<Catmodel, String> catname;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 ResultSet rs = null;
		
		try {
			 rs = conn.createStatement().executeQuery("select * from tbcat order by catname");
			while (rs.next())
			{
				obist.add(new Catmodel(rs.getString("id"), rs.getString("catname")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Functions.invsave(e.getMessage());
		}
		
		
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		catname.setCellValueFactory(new PropertyValueFactory<>("catname"));
		tblcat.setItems(obist);
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Functions.invsave(e.getMessage());
		}
		
		
		//edit mode with double click

		tblcat.setRowFactory( tv -> {
		    TableRow<Catmodel> row = new TableRow<>();
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
							
							Catmodel rowData = row.getItem();
				            System.out.println(rowData.getCatname());
				            String query = "update tbcat set catname = ? where id=" + rowData.getId() +";";	
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
							Catmodel rowData = row.getItem();
				            System.out.println(rowData.getCatname());
				            String query = "update tbcat set catname = ? where id=" + rowData.getId() +";";	
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
	@FXML
	JFXButton ref;
	public void onrefresh(ActionEvent eve) throws IOException
	{
		Stage stage1 = (Stage) ref.getScene().getWindow();
		stage1.close();
		Scene scene1 = (Scene) ref.getScene();
		String s = scene1.getStylesheets().toString();
		
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/catsearch.fxml"));
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
	public void onsearch(ActionEvent e)
	{
		
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
			            Catmodel item= tblcat.getSelectionModel().getSelectedItem();
			       	 tblcat.getItems().remove(item);
			   		 String qu ="delete from tbcat where id = " + item.id + ";";
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
