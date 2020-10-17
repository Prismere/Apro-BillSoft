package com.apro.homescreen;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.ResourceBundle;

import org.springframework.context.annotation.Primary;

import com.apro.comfun.Functions;
import com.apro.invoices.Invoicecontroller;
import com.dlsc.preferencesfx.PreferencesFx;
import com.dlsc.preferencesfx.model.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXNodesList;
import com.jfoenix.controls.JFXToggleButton;

import animatefx.animation.BounceIn;
import animatefx.animation.GlowBackground;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.property.*;
import javafx.beans.value.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class NewMainController extends Application implements Initializable{
	private Stage mainStage;
	@FXML
	AnchorPane anc = new AnchorPane();
	@FXML
	JFXToggleButton tg;
	@FXML
	Pane mpaine = new Pane();
	@FXML
	JFXButton btnref=new JFXButton();
	@FXML
	JFXNodesList invnode = new JFXNodesList();
	JFXColorPicker cp = new JFXColorPicker();
	@FXML
	JFXCheckBox dark = new JFXCheckBox();
	@FXML
	JFXButton btndark,def;
	NewMainController nmc;
	public void refresh(ActionEvent e) throws IOException
	{
		Stage stage1 = (Stage) btnref.getScene().getWindow();
		stage1.close();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/newdash.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		scene.getStylesheets().add("/styles/main.css");
		stage.setTitle("Apro Billing Software:: Version 1.0"); 
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	public void clientview(ActionEvent e) throws IOException
	{
		if(tg.isSelected())
		{
		invnode.animateList(false);
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Clients/newclient.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add("/styles/Dark.css");
		scene.getStylesheets().remove("/styles/main.css");
		Stage stage = new Stage();
		 stage.initModality(Modality.APPLICATION_MODAL);
		 stage.setTitle("Apro Billing Software:: Version 1.0"); 
		   stage.initStyle(StageStyle.UTILITY);
		   stage.setScene(scene);
		   stage.setResizable(false);
		   stage.show();
		}
		if(tg.isSelected()==false)
		{
			invnode.animateList(false);
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/Clients/newclient.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add("/styles/main.css");
			scene.getStylesheets().remove("/styles/Dark.css");
			Stage stage = new Stage();
			 stage.initModality(Modality.APPLICATION_MODAL);
			 stage.setTitle("Apro Billing Software:: Version 1.0"); 
			   stage.initStyle(StageStyle.UTILITY);
			   stage.setScene(scene);
			   stage.setResizable(false);
			   stage.show();
		}
		
	}
	public void newitem(ActionEvent e) throws IOException
	{
		if(tg.isSelected())
		{
		invnode.animateList(false);
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/newitem.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add("/styles/Dark.css");
		scene.getStylesheets().remove("/styles/main.css");
		Stage stage = new Stage();
		 stage.initModality(Modality.APPLICATION_MODAL);
		 stage.setTitle("Apro Billing Software:: Version 1.0"); 
		   stage.initStyle(StageStyle.UTILITY);
		   stage.setScene(scene);
		   stage.setResizable(false);
		   stage.show();
		}
		if(tg.isSelected()==false)
		{
			invnode.animateList(false);
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/newitem.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add("/styles/main.css");
			scene.getStylesheets().remove("/styles/Dark.css");
			Stage stage = new Stage();
			 stage.initModality(Modality.APPLICATION_MODAL);
			 stage.setTitle("Apro Billing Software:: Version 1.0"); 
			   stage.initStyle(StageStyle.UTILITY);
			   stage.setScene(scene);
			   stage.setResizable(false);
			   stage.show();
		}
	}
	public void vendorview(ActionEvent e) throws IOException
	{
		if(tg.isSelected())
		{
		invnode.animateList(false);
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Vendor/newvendor.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add("/styles/Dark.css");
		scene.getStylesheets().remove("/styles/main.css");
		Stage stage = new Stage();
		 stage.initModality(Modality.APPLICATION_MODAL);
		 stage.setTitle("Apro Billing Software:: Version 1.0"); 
		   stage.initStyle(StageStyle.UTILITY);
		   stage.setScene(scene);
		   stage.setResizable(false);
		   stage.show();
		}
		if(tg.isSelected()==false)
		{
			invnode.animateList(false);
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/Vendor/newvendor.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add("/styles/main.css");
			scene.getStylesheets().remove("/styles/Dark.css");
			Stage stage = new Stage();
			 stage.initModality(Modality.APPLICATION_MODAL);
			 stage.setTitle("Apro Billing Software:: Version 1.0"); 
			   stage.initStyle(StageStyle.UTILITY);
			   stage.setScene(scene);
			   stage.setResizable(false);
			   stage.show();
		}
	}
	public void brandview (ActionEvent e) throws IOException
	{
		if(tg.isSelected())
		{
		invnode.animateList(false);
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/newbrand.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add("/styles/Dark.css");
		scene.getStylesheets().remove("/styles/main.css");
		Stage stage = new Stage();
		 stage.initModality(Modality.APPLICATION_MODAL);
		 stage.setTitle("Apro Billing Software:: Version 1.0"); 
		   stage.initStyle(StageStyle.UTILITY);
		   stage.setScene(scene);
		   stage.setResizable(false);
		   stage.show();
		}
		if(tg.isSelected()==false)
		{
			invnode.animateList(false);
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/newbrand.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add("/styles/main.css");
			scene.getStylesheets().remove("/styles/Dark.css");
			Stage stage = new Stage();
			 stage.initModality(Modality.APPLICATION_MODAL);
			 stage.setTitle("Apro Billing Software:: Version 1.0"); 
			   stage.initStyle(StageStyle.UTILITY);
			   stage.setScene(scene);
			   stage.setResizable(false);
			   stage.show();
		}
	}

	public void catview (ActionEvent e) throws IOException
	{
		if(tg.isSelected())
		{
		invnode.animateList(false);
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/newcategory.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add("/styles/Dark.css");
		scene.getStylesheets().remove("/styles/main.css");
		Stage stage = new Stage();
		 stage.initModality(Modality.APPLICATION_MODAL);
		 stage.setTitle("Apro Billing Software:: Version 1.0"); 
		   stage.initStyle(StageStyle.UTILITY);
		   stage.setScene(scene);
		   stage.setResizable(false);
		   stage.show();
		}
		if(tg.isSelected()==false)
		{
			invnode.animateList(false);
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/newcategory.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add("/styles/main.css");
			scene.getStylesheets().remove("/styles/Dark.css");
			Stage stage = new Stage();
			 stage.initModality(Modality.APPLICATION_MODAL);
			 stage.setTitle("Apro Billing Software:: Version 1.0"); 
			   stage.initStyle(StageStyle.UTILITY);
			   stage.setScene(scene);
			   stage.setResizable(false);
			   stage.show();
		}
	}
	public void purview(ActionEvent e) throws IOException
	{

		if(tg.isSelected())
		{
		invnode.animateList(false);
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Purchase/newpurchase.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add("/styles/Dark.css");
		scene.getStylesheets().remove("/styles/main.css");
		Stage stage = new Stage();
		 stage.initModality(Modality.APPLICATION_MODAL);
		 stage.setTitle("Apro Billing Software:: Version 1.0"); 
		   stage.initStyle(StageStyle.UTILITY);
		   stage.setScene(scene);
		   stage.setResizable(false);
		   stage.show();
		}
		if(tg.isSelected()==false)
		{
			invnode.animateList(false);
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/Purchase/newpurchase.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add("/styles/main.css");
			scene.getStylesheets().remove("/styles/Dark.css");
			Stage stage = new Stage();
			 stage.initModality(Modality.APPLICATION_MODAL);
			 stage.setTitle("Apro Billing Software:: Version 1.0"); 
			   stage.initStyle(StageStyle.UTILITY);
			   stage.setScene(scene);
			   stage.setResizable(false);
			   stage.show();
		}
		
		
		
		
	}
	public void saleview(ActionEvent e)
	{
	
	}
	public void repview(ActionEvent e)
	{
		
	}
	public void onset(ActionEvent e) 
	{
		
	}
	public void onsearch(ActionEvent e) throws IOException
	{
		if(tg.isSelected())
		{
		invnode.animateList(false);
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/newitemstock.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add("/styles/Dark.css");
		scene.getStylesheets().remove("/styles/main.css");
		Stage stage = new Stage();
		 stage.initModality(Modality.APPLICATION_MODAL);
		 stage.setTitle("Apro Billing Software:: Version 1.0"); 
		   stage.initStyle(StageStyle.UTILITY);
		   stage.setScene(scene);
		   stage.setResizable(false);
		   stage.show();
		}
		if(tg.isSelected()==false)
		{
			invnode.animateList(false);
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/Items/newitemstock.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add("/styles/main.css");
			scene.getStylesheets().remove("/styles/Dark.css");
			Stage stage = new Stage();
			 stage.initModality(Modality.APPLICATION_MODAL);
			 stage.setTitle("Apro Billing Software:: Version 1.0"); 
			   stage.initStyle(StageStyle.UTILITY);
			   stage.setScene(scene);
			   stage.setResizable(false);
			   stage.show();
		}
	}

	public void oninv(ActionEvent e) throws IOException
	{
	if(tg.isSelected())
	{
	invnode.animateList(false);
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Invoices/newinvoice.fxml"));
	Parent root = (Parent) loader.load();
	
	
	Invoicecontroller inc = (Invoicecontroller) loader.getController();
	
	inc.ad(tg.isSelected());
	
	Scene scene = new Scene(root);
	scene.getStylesheets().add("/styles/Dark.css");
	scene.getStylesheets().remove("/styles/main.css");
	Stage stage = new Stage();
	 stage.initModality(Modality.APPLICATION_MODAL);
	 stage.setTitle("Apro Billing Software:: Version 1.0"); 
	   stage.initStyle(StageStyle.UTILITY);
	   stage.setScene(scene);
	   stage.setResizable(false);
	   stage.show();
	}
	if(tg.isSelected()==false)
	{
		invnode.animateList(false);
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Invoices/newinvoice.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add("/styles/main.css");
		scene.getStylesheets().remove("/styles/Dark.css");
		Stage stage = new Stage();
		 stage.initModality(Modality.APPLICATION_MODAL);
		 stage.setTitle("Apro Billing Software:: Version 1.0"); 
		   stage.initStyle(StageStyle.UTILITY);
		   stage.setScene(scene);
		   stage.setResizable(false);
		   stage.show();
	}
}
	@FXML
	JFXButton exp,imp;
	
	public void onimport(ActionEvent exe) throws IOException
	{
		Path to = null;
		 Path from = null;
		 File selectedFile;
		 FileChooser fc = new FileChooser();
		    fc.setTitle("Attach a file");
		    selectedFile = fc.showOpenDialog(null);
		   
		    if (selectedFile != null) {
		        from = Paths.get(selectedFile.toURI());
		        to = Paths.get(selectedFile.getName());
		        
		        Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
		        System.out.println(from);
		        System.out.println(to);
		    }
		
	}
	public void onexport(ActionEvent ex)
	{
		Stage primaryStage=(Stage) exp.getScene().getWindow();
	        Stage sta = new Stage();
	        Text text = new Text();
	        text.setFill(Color.RED);
	        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 35)); 
	        text.setText("Important: Do not change the name of the file");
	        JFXDialogLayout content= new JFXDialogLayout();
	   	    content.setBody(text);
	   	    StackPane stackpane = new StackPane();
	   	    JFXDialog dialog =new JFXDialog(stackpane, content, JFXDialog.DialogTransition.CENTER);
	   	    JFXButton button=new JFXButton("Okay");
	   	    button.setOnAction(new EventHandler<ActionEvent>(){
	   	        @Override
	   	        public void handle(ActionEvent event){
	   	        	FileChooser file = new FileChooser();  
	   		        file.setTitle("Save Database");
	   		        
	   		        file.getExtensionFilters().addAll(
	   		        new FileChooser.ExtensionFilter("SQLite", "*.sqlite"));
	   		        file.setInitialFileName("testdb");
	   		        file.setInitialDirectory(new File("C:\\")); 
	   		        File file1 = file.showSaveDialog(primaryStage);  
	   		        System.out.println(file1);  
	   		        Path source = Paths.get("testdb.sqlite");
	   		        Path target = Paths.get(file1.toString());
	   	        	try
	   	        	{
	   	 			Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
	   	 			Functions.invsave("Backup Success");
	   	        	}
	   	        	catch(IOException e)
	   	        	{
	   	 			Functions.invsave(e.getMessage());
	   	        	}
	   	        	sta.close();
	   	        }
	   	    });
	   	    content.setActions(button);
	   	    Scene scene = new Scene(stackpane);
	   	    sta.initModality(Modality.APPLICATION_MODAL);
	   	    sta.setTitle("Apro Billing Software:: Version 1.0"); 
	   	    sta.initStyle(StageStyle.UTILITY);
	   	    sta.setScene(scene);
	   	    dialog.show();
	   	    sta.setResizable(false);
	   	    sta.show();	
	}

	@Override
	public void start(Stage stage) throws Exception
	{
		
	
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		new GlowBackground(anc,Color.rgb(1, 224, 223),Color.rgb(2,204,252),20)
		.setDelay(Duration.seconds(.1))
		.setCycleCount(7000)
		.setSpeed(.3)
		.setResetOnFinished(true).play();
		
		tg.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(tg.isSelected()==true)
				{
					Scene scene = tg.getScene();
					scene.getStylesheets().add("/styles/Dark.css");
					scene.getStylesheets().remove("/style/main.css");
					new GlowBackground(anc,Color.rgb(1, 224, 223),Color.rgb(2,204,252),20)
					.setDelay(Duration.seconds(.1))
					.setCycleCount(7000)
					.setSpeed(.3)
					.setResetOnFinished(true).play();
				}
				else
				{
					Scene scene = tg.getScene();
					scene.getStylesheets().add("styles/main.css");
					scene.getStylesheets().remove("/styles/Dark.css");
					
				}	
			}
		});
	}
	
}
