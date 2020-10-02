package com.apro.theme;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXColorPicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Themecontrol {
	@FXML
	public JFXColorPicker clrbg,clrtxt;
	@FXML
	public Label txtclr, txtbg;
	@FXML
	Pane pane = new Pane();
	@FXML
	JFXButton btnsave = new JFXButton();
	@FXML
	JFXButton btncancel = new JFXButton();
	public void onsave(ActionEvent e) throws IOException
		{
		Stage stage1 = (Stage) btnsave.getScene().getWindow();
		stage1.close();	
		}
	public void changecolor(ActionEvent e) {
		Color col=clrbg.getValue();
	pane.setBackground(new Background(new BackgroundFill(Paint.valueOf(col.toString()), CornerRadii.EMPTY, Insets.EMPTY)));
	
	}
	public void changetext (ActionEvent e)
	{
		Color col=clrtxt.getValue();
		txtclr.setTextFill(Paint.valueOf(col.toString()));
		txtbg.setTextFill(Paint.valueOf(col.toString()));
		
	}
}
