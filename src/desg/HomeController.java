package com.apro.homescreen;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.sqlite.SQLiteConnection;
import java.lang.reflect.Field;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import org.kordamp.ikonli.*;
import org.kordamp.ikonli.javafx.FontIcon;

import com.apro.login.SqliteConnection;
import com.sun.javafx.reflect.FieldUtil;

public class HomeController {
	Connection conn;

	public HomeController() {
		conn = SqliteConnection.Connector();
		if (conn == null) {
			System.out.println("Connection Not Successful");

			System.exit(1);
		}
	}

	public boolean isDbConnected() {
		try {
			return !conn.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static Connection Connector() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn1 = DriverManager.getConnection("jdbc:sqlite:testdb.sqlite");
			return conn1;
		} catch (Exception e) {
			return null;
		}
	}

	@FXML
	Tooltip thome = new Tooltip("Dashboard");
	Tooltip tvendor = new Tooltip("Vendor");
	Tooltip tclient = new Tooltip("Client");
	Tooltip tinvoice = new Tooltip("Invoice");
	Tooltip tpurchase = new Tooltip("Purchase");
	Tooltip tsale = new Tooltip("Sales");
	Tooltip treport = new Tooltip("Reports");
	Tooltip tsetting = new Tooltip("Settings");

	@FXML
	TextField cliname = new TextField();
	@FXML
	TextField cliph = new TextField();
	@FXML
	TextField cliemail = new TextField();
	@FXML
	TextArea cliadd = new TextArea();
	@FXML
	Label lblmsg = new Label();

	@FXML
	AnchorPane optvbox = new AnchorPane();
	@FXML
	Label b = new Label();
	@FXML
	FontIcon navicon = new FontIcon();
	@FXML
	FontIcon home = new FontIcon();
	@FXML
	FontIcon vendor = new FontIcon();
	@FXML
	FontIcon client = new FontIcon();
	@FXML
	FontIcon invoice = new FontIcon();
	@FXML
	FontIcon purchase = new FontIcon();
	@FXML
	FontIcon sale = new FontIcon();
	@FXML
	FontIcon report = new FontIcon();
	@FXML
	FontIcon setting = new FontIcon();
	@FXML
	AnchorPane vendorview = new AnchorPane();
	@FXML
	AnchorPane clientview = new AnchorPane();
	@FXML
	AnchorPane addclientform = new AnchorPane();
	@FXML
	AnchorPane dashview = new AnchorPane();
	@FXML
	AnchorPane invoiceview = new AnchorPane();

	@FXML
	public void homeenter(MouseEvent eve) {
		Tooltip.install(home, thome);
		thome.setShowDelay(Duration.seconds(.1));
	}

	@FXML
	public void vendorenter(MouseEvent event) {
		Tooltip.install(vendor, tvendor);
		tvendor.setShowDelay(Duration.seconds(.1));
	}

	@FXML
	public void cliententer(MouseEvent event) {
		Tooltip.install(client, tclient);
		tclient.setShowDelay(Duration.seconds(.1));
	}

	@FXML
	public void invoiceenter(MouseEvent event) {
		Tooltip.install(invoice, tinvoice);
		tinvoice.setShowDelay(Duration.seconds(.1));
	}

	@FXML
	public void purchaseenter(MouseEvent event) {
		Tooltip.install(purchase, tpurchase);
		tpurchase.setShowDelay(Duration.seconds(.1));
	}

	@FXML
	public void saleenter(MouseEvent event) {
		Tooltip.install(sale, tsale);
		tsale.setShowDelay(Duration.seconds(.1));
	}

	@FXML
	public void reportenter(MouseEvent event) {
		Tooltip.install(report, treport);
		treport.setShowDelay(Duration.seconds(.1));
	}

	@FXML
	public void settingenter(MouseEvent event) {
		Tooltip.install(setting, tsetting);
		tsetting.setShowDelay(Duration.seconds(.1));
	}

	public void venclick(MouseEvent event) {
		vendorview.setVisible(true);
		vendorview.toFront();
		clientview.setVisible(false);
	}

	public void clientclick(MouseEvent event) {
		clientview.setVisible(true);
		clientview.toFront();
		vendorview.setVisible(false);
	}

	public void dashclick(MouseEvent event) {
		dashview.toFront();
	}

	public void invoiceclick(MouseEvent event) {
		invoiceview.toFront();
	}

	public void navclick(MouseEvent event) {
		TranslateTransition opennav = new TranslateTransition(new Duration(350), optvbox);
		opennav.setToX(0);
		TranslateTransition closenav = new TranslateTransition(new Duration(350), optvbox);
		if (optvbox.getTranslateX() != 0) {
			opennav.play();
		} else {
			closenav.setToX(-(optvbox.getWidth()));
			closenav.play();
		}
	}

	/*
	 * if(optvbox.isVisible()==true) { optvbox.setVisible(false); } else {
	 * optvbox.setVisible(true); } }
	 */
	public void addclient(ActionEvent event) {
		addclientform.toFront();
	}

	public void clifrmsave(ActionEvent event) throws SQLException  {
		
		ResultSet resultset = null;
		String cname = cliname.getText();
		String cadd = cliadd.getText();
		String cphone = cliph.getText();
		String cmail = cliemail.getText();
		System.out.println(cname);
		System.out.println(cphone);
		System.out.println(cadd);
		System.out.println(cmail);
		Statement stmt=null;
		
		  Connection conection = SqliteConnection.Connector();
		  String query="INSERT INTO clientn (name,address,phone,email) values (?,?,?,?);";
		  PreparedStatement prep=conn.prepareStatement(query);
		  try {
			  if(cliname.getText().isEmpty()|cliph.getText().isEmpty()|cliadd.getText().isEmpty()|cliemail.getText().isEmpty())
			  {
				  lblmsg.setText("Fill all fields");
			  }
			  else
			  {
			  prep.setString(1, cname);
			  prep.setString(2, cadd);
			  prep.setString(3, cphone);
			  prep.setString(4, cmail);
			  prep.executeUpdate();
			  lblmsg.setText("Added successfully");
			  }
		 } catch (SQLException e) { // TODO Auto-generated catch block
		  System.out.println("Error");
		  lblmsg.setText("There is some issue. Try again");}
	}
	public void clifrmcan(ActionEvent event)
	{
		cliname.setText(null);
		cliadd.setText(null);
		cliph.setText(null);
		cliemail.setText(null);
		addclientform.toBack();
	}
}
