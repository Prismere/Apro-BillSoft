package com.apro.report;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.print.PrinterJob.JobStatus;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class InvoiceprintController extends Application{
	private final Label jobStatus = new Label();
	
    @FXML
    Button btnsaveinv = new Button();
    Stage stg = new Stage();
    @FXML
    AnchorPane printview = new AnchorPane();
    @FXML
    VBox printbox = new VBox();
    
    @Override
    public void start(final Stage stage) throws IOException
    {
        // Create the Text Label
        Label textLabel = new Label("Please insert your Text:");
 
        // Create the TextArea
        final TextArea textArea = new TextArea();
 
        // Create the Buttons
        Button printSetupButton = new Button("Print Setup and Print");
         
        // Create the Event-Handlers for the Button
        btnsaveinv.setOnAction(new EventHandler <ActionEvent> () 
        {
            public void handle(ActionEvent event) 
            {
                printSetup(textArea, stg);
            }
        });
         
        // Create the Status Box
        HBox jobStatusBox = new HBox(5, new Label("Job Status: "), jobStatus);
        // Create the Button Box
        HBox buttonBox = new HBox(printSetupButton);
         
        // Create the VBox
        VBox root = new VBox(5);
        printview.getChildren().addAll(textLabel, textArea, buttonBox, jobStatusBox);
        printbox.getChildren().addAll(textLabel, textArea, buttonBox, jobStatusBox);
        // Add the Children to the VBox     
        root.getChildren().addAll(textLabel, textArea, buttonBox, jobStatusBox);
        // Set the Size of the VBox
        root.setPrefSize(400, 300);     
         
        // Set the Style-properties of the VBox
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
         
        // Create the Scene
        Parent root1=FXMLLoader.load(getClass().getResource("/fxml/Report/prodbill.fxml"));
        Scene scene = new Scene(root1);
        // Add the scene to the Stage
        stage.setScene(scene);
        // Set the title of the Stage
        stage.setTitle("A Printing Dialog Example");
        // Display the Stage
        stage.show();      
    
    }
     
    private void printSetup(Node node, Stage owner) 
    {
        // Create the PrinterJob        
        PrinterJob job = PrinterJob.createPrinterJob();
     
        if (job == null) 
        {
            return;
        }
 
        // Show the print setup dialog
        boolean proceed = job.showPrintDialog(owner);
         
        if (proceed) 
        {
            print(job, node);
        }
    }
     
    private void print(PrinterJob job, Node node) 
    {
        // Set the Job Status Message
        jobStatus.textProperty().bind(job.jobStatusProperty().asString());
         
        // Print the node
        boolean printed = job.printPage(node);
     
        if (printed) 
        {
            job.endJob();
        }
    }   
    public void printinv(ActionEvent evnet)
    {
    	Printer print= Printer.getDefaultPrinter();
    	PageLayout page=print.createPageLayout(Paper.A4, PageOrientation.PORTRAIT, Printer.MarginType.HARDWARE_MINIMUM);
    	PrinterJob jo= PrinterJob.createPrinterJob();
    	if(jo!=null && jo.showPrintDialog(printview.getScene().getWindow()))
    	{
    		boolean suc=jo.printPage(page, printview);
    		if(suc)
    		{
    			jo.endJob();
    		}
    	}
    }
}
