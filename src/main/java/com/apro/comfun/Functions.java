package com.apro.comfun;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Functions {
	public static void invsave(String msg) {
	Stage primaryStage = new Stage();
	 JFXDialogLayout content= new JFXDialogLayout();
	    content.setHeading(new Text(msg));
	    content.setBody(new Text("Operation Successfull"));
	    StackPane stackpane = new StackPane();
	    JFXDialog dialog =new JFXDialog(stackpane, content, JFXDialog.DialogTransition.CENTER);
	    JFXButton button=new JFXButton("Okay");
	    button.setOnAction(new EventHandler<ActionEvent>(){
	        @Override
	        public void handle(ActionEvent event){
	            dialog.close();
	            primaryStage.close();
	        }
	    });
	    content.setActions(button);
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
