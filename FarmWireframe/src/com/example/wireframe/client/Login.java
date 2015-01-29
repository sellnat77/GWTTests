package com.example.wireframe.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Login 
{
		private TextBox tbUsername = new TextBox();
		private PasswordTextBox tbPassword = new PasswordTextBox();
		private Button bLoginSubmit = new Button("Login");
		private Label lLogin = new Label("Please Log In");		
		private Label lUsername = new Label("Usersname");
		private Label lPassword = new Label("password");
		private VerticalPanel pLoginMain = new VerticalPanel();
		private TabPanel pLoginTab = new TabPanel();
		private FlexTable ftLoginScreen = new FlexTable();
		
		/**
		 * Provides the panel portion for the login screen
		 * 
		 * @author Russell 
		 * 
		 * @return Returns a tab panel pLoginTab to be added to the root panel
		 */
		public TabPanel getPanel()
		{
			ftLoginScreen.setWidget(0, 0, lUsername);
			ftLoginScreen.setWidget(0, 1, tbUsername);
			ftLoginScreen.setWidget(1, 0, lPassword);
			ftLoginScreen.setWidget(1, 1, tbPassword);
			ftLoginScreen.setWidget(2, 1, bLoginSubmit);
			
			lLogin.addStyleName("loginText");
			tbUsername.addStyleName("textFields");
			tbPassword.addStyleName("textFields");
			lUsername.addStyleName("loginLabels");
			lPassword.addStyleName("loginLabels");
			bLoginSubmit.addStyleName("loginButton");
			
			pLoginMain.add(lLogin);
			pLoginMain.add(ftLoginScreen);
			
			pLoginMain.addStyleName("mainPanel");
			pLoginTab.add(pLoginMain,"Login");
			
			return pLoginTab;
		}
}
