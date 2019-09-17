package za.co.wethinkcode;

public class VisibilityManager {

	UI ui;

	public VisibilityManager(UI userInterface){
		ui = userInterface;
	}

	public void titleToTown(){
		// hide the title screen
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);

		// show game screen
		ui.mainTextPanel.setVisible(true);
		ui.choiceButtonPanel.setVisible(true);
		ui.playerPanel.setVisible(true);
	}

	public void showTitleScreen()
	{
		// show the showTitleScreen
		ui.titleNamePanel.setVisible(true);
		ui.startButtonPanel.setVisible(true);
		
		// hide game screen
		ui.mainTextPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.playerPanel.setVisible(false);
	}
}