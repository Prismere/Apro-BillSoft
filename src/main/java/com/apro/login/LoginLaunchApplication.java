package com.apro.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginLaunchApplication extends Application{
	private double xOffset = 0;
	 private double yOffset = 0;
	public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
       root.setOnMousePressed((MouseEvent event) -> {
           xOffset = event.getSceneX();
           yOffset = event.getSceneY();
       });
       root.setOnMouseDragged((MouseEvent event) -> {
           stage.setX(event.getScreenX() - xOffset);
           stage.setY(event.getScreenY() - yOffset);
       });
       Scene scene = new Scene(root);
       stage.setTitle("Inventory:: Version 1.0");
		/* stage.getIcons().add(new Image("/images/logo.png")); */
		 stage.initStyle(StageStyle.UNDECORATED);
       stage.setScene(scene);       
       stage.show();
   }

}
