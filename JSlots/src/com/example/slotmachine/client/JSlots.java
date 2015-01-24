package com.example.slotmachine.client;


import javax.swing.*;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;

public class JSlots implements EntryPoint{

	public void onModuleLoad() {
		
		int Mover,Action,Gain,Bet,ColorChanger,Spins,Credits,CashSpent;

		Timer T;

		Panel PTop      = new Panel();
		Panel PStats    = new Panel();
		Panel PLeft     = new Panel();
		Panel PRight    = new Panel();
		Panel PBottom   = new Panel();
		Panel PCenter   = new Panel();
		Panel PNumbers  = new Panel();
		Panel PStatsOne = new Panel();
		Panel PStatsTwo = new Panel();

		Image GSides     = new Image("Sides.gif"  );
		Image GTopBottom = new Image("Top.gif"    );
		Image GSpinner   = new Image("Spinner.gif");
		Image GJackPot   = new Image("JackPot.gif");

		Label LSides        = new Label(GSides    );
		Label LSides2       = new Label(GSides    );
		Label LSides3       = new Label(GSides    );
		Label RSides        = new Label(GSides    );
		Label RSides2       = new Label(GSides    );
		Label RSides3       = new Label(GSides    );
		Label LTopLeft      = new Label(GTopBottom);
		Label LTopRight     = new Label(GTopBottom);
		Label LBotLeft      = new Label(GTopBottom);
		Label LBotRight     = new Label(GTopBottom);
		Label LTopLeftOne   = new Label(GTopBottom);
		Label LTopRightOne  = new Label(GTopBottom);
		Label LTopLeftTwo   = new Label(GTopBottom);
		Label LTopRightTwo  = new Label(GTopBottom);
		Label LTopLeftThree = new Label(GTopBottom);
		Label LTopRightThree= new Label(GTopBottom);
	    Label LSpinnerLeft  = new Label(GSpinner  );
	    Label LSpinnerRight = new Label(GSpinner  );


		Label LCashSpent   = new Label("Cash Spent"     );
		Label LNetGain     = new Label("Net Gain"       );
		Label LGamesPlayed = new Label("Games Played"   );
		Label LCredit      = new Label("Credits"        );
		Label LTitle       = new Label("The Pot 'O Gold");

		Button BBet     = new Button("Increase Bet");
		Button BDecBet  = new Button("Decrease Bet");
		Button BSpin    = new Button("Spin"        );
		Button BSkip    = new Button("Skip"        );
		Button BCashOut = new Button("Cash Out"    );

		TextBox TSpinOne    = new TextBox( );
		TextBox TSpinTwo    = new TextBox( );
		TextBox TSpinThree  = new TextBox( );
		TextBox TStatsOne   = new TextBox( );
		TextBox TStatsTwo   = new TextBox( );
		TextBox TStatsThree = new TextBox( );
		TextBox TStatsFour  = new TextBox( );
		TextBox TCurrentBet = new TextBox( );		

		Mover     = 0        ;
		Bet       = 1        ;
		Gain      = 0        ;
		Spins     = 0        ;
		CashSpent = 0        ;
		Credits   = 200      ;




		Grid   SideLayout    = new Grid  (3,1                   );
		Grid   StatsLayout   = new Grid  (1,4                   );
		FlowPanel   Default       = new FlowPanel  (                      );
		Grid   CentralLayout = new Grid  (2,1                   );
		Grid   TopCentral    = new Grid  (1,5                   );
		Grid   BotCentral    = new Grid  (2,4                   );

		PTop.setLayout     (Default      );
		PLeft.setLayout    (SideLayout   );
		PRight.setLayout   (SideLayout   );
		PBottom.setLayout  (Default      );
		PCenter.setLayout  (CentralLayout);
		PNumbers.setLayout (TopCentral   );
		PStats.setLayout   (StatsLayout  );
	    PStatsOne.setLayout(BotCentral   );
	    PStatsTwo.setLayout(BotCentral   );













	    TStatsFour.setText(""+Credits);

	    PNumbers.add(LSpinnerLeft );
	    PNumbers.add(TSpinOne     );
	    PNumbers.add(TSpinTwo     );
	    PNumbers.add(TSpinThree   );
	    PNumbers.add(LSpinnerRight);

	    PStatsOne.add(TStatsOne   );
	    PStatsOne.add(LCashSpent  );
	    PStatsOne.add(LNetGain    );
	    PStatsOne.add(TStatsTwo   );
	    PStatsOne.add(TStatsThree );
	    PStatsOne.add(LGamesPlayed);
	    PStatsOne.add(LCredit     );
	    PStatsOne.add(TStatsFour  );

	    PTop.add(LTopLeft );
	    PTop.add(LTopLeftOne );
	    PTop.add(LTopLeftTwo );

	    PTop.add(LTitle   );
	    PTop.add(LTopRight);
	    PTop.add(LTopRightOne);
	    PTop.add(LTopRightTwo);


	    PBottom.add(LBotLeft   );
	    PBottom.add(TCurrentBet);
	    PBottom.add(BBet       );
	    PBottom.add(BDecBet    );
	    PBottom.add(BSpin      );
	    PBottom.add(BCashOut   );
	    PBottom.add(LBotRight  );

	    PLeft.add (LSides );
	    PLeft.add (LSides2);
	    PLeft.add (LSides3);
	    PRight.add(RSides );
	    PRight.add(RSides2);
	    PRight.add(RSides3);

	    PCenter.add(PNumbers );
	    PCenter.add(PStatsOne);

	    add(PRight   );
	    add(PLeft,BorderLayout.WEST    );
	    add(PTop,BorderLayout.NORTH    );
	    add(PBottom,BorderLayout.SOUTH );
	    add(PCenter,BorderLayout.CENTER);

	    
		

		
	}
	
}