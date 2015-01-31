package com.example.wireframe.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;


public class FarmWireframe implements EntryPoint {


	public void onModuleLoad() 
	{
		//Hello Testing!
		TabPanel tpMainMenu = new TabPanel();
		
		Login loginScreen = new Login();
		Home homeScreen = new Home();
		Patient patientScreen = new Patient();
		PatientData dataScreen = new PatientData();
		
		tpMainMenu.add(homeScreen.getPanel(), "Home");
		tpMainMenu.add(patientScreen.getPanel(), "New Patient");
		tpMainMenu.add(dataScreen.getPanel(), "Search Patients");
		tpMainMenu.add(loginScreen.getPanel(1),"Logout");
		tpMainMenu.setWidth("100%");
		
		RootPanel.get().setWidth("100%");
		
		RootPanel.get("loginForm").add(loginScreen.getPanel());
		RootPanel.get("loginForm").add(tpMainMenu);
	}
}
