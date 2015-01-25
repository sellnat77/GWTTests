package com.example.wireframe.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.cellview.client.DataGrid;
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
		//////////////////////////////////////////////////////////////////////////////////////////
		//This is for the patient screen
		VerticalPanel newPatientP = new VerticalPanel();
		HorizontalPanel patientInfoP = new HorizontalPanel();
		HorizontalPanel saveSendP = new HorizontalPanel();
		FlexTable patientDataFT = new FlexTable();
		FlexTable docDataFT = new FlexTable();
		
		Label newPatTitleL = new Label("Add New Patient");		
		Label patNameL = new Label("Name:");
		Label patDOBL = new Label("Date of Birth:");
		Label patAddrL = new Label("Address:");
		Label patPharmL = new Label("Pharmacy:");
		Label docNotesL = new Label("Notes:");
		Label docPrescripL = new Label("Prescription:");
		Label docSigL = new Label("E-Signature:");
		
		TextBox patNameTB = new TextBox();
		TextBox patDOBTB = new TextBox();
		TextBox patAddrTB = new TextBox();
		TextArea docNotesTA = new TextArea();
		TextBox docPrescripTB = new TextBox();
		TextBox docSigTB = new TextBox();
		
		ListBox patPharmLB = new ListBox();
		
		Button addPrescriptB = new Button("Add Prescription");
		Button savePatientB = new Button("Save");
		Button sendPrescripB = new Button("Send Prescription");
		
		newPatTitleL.addStyleName("loginText");
		newPatientP.add(newPatTitleL);
		
		patientDataFT.setWidget(0, 0, patNameL);
		patientDataFT.setWidget(0, 1, patNameTB);
		patientDataFT.setWidget(1, 0, patDOBL);
		patientDataFT.setWidget(1, 1, patDOBTB);
		patientDataFT.setWidget(2, 0, patAddrL);
		patientDataFT.setWidget(2, 1, patAddrTB);		
		patientDataFT.setWidget(3, 0, patPharmL);
		patientDataFT.setWidget(3, 1, patPharmLB);
		
		patientInfoP.add(patientDataFT);
		
		newPatientP.add(patientInfoP);
		
		docDataFT.setWidget(0, 0, docNotesL);
		docDataFT.setWidget(0, 1, docNotesTA);
		docDataFT.setWidget(1, 0, docPrescripL);
		docDataFT.setWidget(1, 1, docPrescripTB);
		docDataFT.setWidget(1, 2, addPrescriptB);
		docDataFT.setWidget(2, 0, docSigL);
		docDataFT.setWidget(2, 1, docSigTB);
		
		newPatientP.add(docDataFT);
		
		saveSendP.add(savePatientB);
		saveSendP.add(sendPrescripB);
		
		newPatientP.add(saveSendP);
		
		newPatientP.addStyleName("mainPanel");
		////////////////////////////////////////////////////////////////////////////////////////////////////
		//This is for the data grid implementation to display records from a database
		VerticalPanel mainTableP = new VerticalPanel();
		HorizontalPanel modDeleteP = new HorizontalPanel();
		
		Label mainTableL = new Label("Patient Records");
		
		Button modifyPatB = new Button("Modify");
		Button deletePatB = new Button("Delete");
		
		DataGrid patientTableDG = new DataGrid();
		
		mainTableL.addStyleName("loginText");
		mainTableP.add(mainTableL);
		
		mainTableP.add(patientTableDG);
		
		modDeleteP.add(deletePatB);
		modDeleteP.add(modifyPatB);
		
		mainTableP.add(modDeleteP);
		mainTableP.addStyleName("mainPanel");
		/////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		RootPanel.get("loginForm").add(loginMainP);
		RootPanel.get("loginForm").add(homeP);
		RootPanel.get("loginForm").add(newPatientP);
		RootPanel.get("loginForm").add(mainTableP);
	}
	
}
