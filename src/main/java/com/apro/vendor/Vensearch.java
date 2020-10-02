package com.apro.vendor;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.apro.brand.Brandsearchmodel;
import com.apro.comfun.Functions;
import com.apro.login.SqliteConnection;
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

public class Vensearch implements Initializable{

	Connection conn;
	public Vensearch()
	{
		conn=SqliteConnection.Connector();
	}
	
	ObservableList<Venmodel> obist = FXCollections.observableArrayList();
	@FXML
	TableView<Venmodel> tblven;
	@FXML
	TableColumn<Venmodel, String> id;
	@FXML
	TableColumn<Venmodel, String> vname;
	@FXML
	TableColumn<Venmodel, String> vemail;
	@FXML
	TableColumn<Venmodel, String> vphone;
	@FXML
	TableColumn<Venmodel, String> vtin;
	@FXML
	TableColumn<Venmodel, String> vpan;
	@FXML
	TableColumn<Venmodel, String> vgst;
	@FXML
	TableColumn<Venmodel, String> vaddress;
	@FXML
	TableColumn<Venmodel, String> vcode;
	@FXML
	TableColumn<Venmodel, String> status;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 ResultSet rs = null;
		try {
			 rs = conn.createStatement().executeQuery("select * from vendor");
			while (rs.next())
			{
				obist.add(new Venmodel(rs.getString("id"), rs.getString("vname"), rs.getString("vemail"), rs.getString("vphone"), rs.getString("vaddress"), rs.getString("vtin"), rs.getString("vpan"), rs.getString("vgst"), rs.getString("vcode"), rs.getString("status")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Functions.invsave(e.getMessage());
		}
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		vname.setCellValueFactory(new PropertyValueFactory<>("vname"));
		vemail.setCellValueFactory(new PropertyValueFactory<>("vemail"));
		vphone.setCellValueFactory(new PropertyValueFactory<>("vphone"));
		vtin.setCellValueFactory(new PropertyValueFactory<>("vtin"));
		vpan.setCellValueFactory(new PropertyValueFactory<>("vpan"));
		vaddress.setCellValueFactory(new PropertyValueFactory<>("vaddress"));
		vgst.setCellValueFactory(new PropertyValueFactory<>("vgst"));
		vcode.setCellValueFactory(new PropertyValueFactory<>("vcode"));
		status.setCellValueFactory(new PropertyValueFactory<>("status"));
		tblven.setItems(obist);
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
			            Venmodel item= tblven.getSelectionModel().getSelectedItem();
			       	 tblven.getItems().remove(item);
			   		 String qu ="delete from vendor where id = " + item.id + ";";
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
