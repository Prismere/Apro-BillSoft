package com.apro.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class clientController {
	@FXML
 AnchorPane clientview= new AnchorPane();
	public void addclient(ActionEvent event)
	{
		clientview.toFront();
	}
	
}
