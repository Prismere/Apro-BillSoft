package com.apro.login;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apro.aproerp.AproErpApplication;

import javafx.application.Application;

@SpringBootApplication
public class LoginApplication {
	public static void main (String[] args) {
		Application.launch(LoginLaunchApplication.class,args);
	}
}
