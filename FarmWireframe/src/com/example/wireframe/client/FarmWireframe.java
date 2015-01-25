package com.example.wireframe.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;


public class FarmWireframe implements EntryPoint {


	public void onModuleLoad() {
		//This is for the login screen - very basic right now
		TextBox usernameTB = new TextBox();
		PasswordTextBox passwordTB = new PasswordTextBox();
		Button loginSubmitB = new Button("Submit");
		Label loginL = new Label("User Login");		
		Label usernameL = new Label("Usersname");
		Label passwordL = new Label("password");
		VerticalPanel loginMainP = new VerticalPanel();

		FlexTable loginScreenFT = new FlexTable();
		
		loginScreenFT.setWidget(0, 0, usernameL);
		loginScreenFT.setWidget(0, 1, usernameTB);
		loginScreenFT.setWidget(1, 0, passwordL);
		loginScreenFT.setWidget(1, 1, passwordTB);
		loginScreenFT.setWidget(2, 1, loginSubmitB);
		
		loginL.addStyleName("loginText");
		
		loginMainP.add(loginL);
		loginMainP.add(loginScreenFT);
		
		loginMainP.addStyleName("mainPanel");
		///////////////////////////////////////////////////////////////////////////////////////////
		//This is for the home screen
		HorizontalPanel homeP = new HorizontalPanel();
		FlexTable homeFT = new FlexTable();
		VerticalPanel buttonP = new VerticalPanel();
		Button newPatientB = new Button("New Patient");
		Button searchPatientsB = new Button("Search Patients");
		Button settingsB = new Button("Settings");
		Image logoI = new Image("repository_logo.png");
	
		
		buttonP.add(newPatientB);
		buttonP.add(searchPatientsB);
		buttonP.add(settingsB);
		
		
		homeFT.setWidget(0, 0, logoI);
		homeFT.setWidget(0, 1, buttonP);
		homeP.add(homeFT);
		homeP.addStyleName("mainPanel");
		
		
		
		
		
		RootPanel.get("loginForm").add(loginMainP);
		RootPanel.get("loginForm").add(homeP);
		
	}
	
}
