package za.co.wethinkcode.Controller;
import java.awt.event.ActionListener;
import za.co.wethinkcode.views.ConsoleViews;
import 	za.co.wethinkcode.model.Model;

public class Controller {
	private Model model;
	// private view view;
	private ConsoleViews consoleViews;
	private String gameMode;

	public Controller(Model theModel, ConsoleViews theconsoleViews, String gameMode)
	{
		if (gameMode.equalsIgnoreCase("console"))
		{
			consoleViews = theconsoleViews;
			gameMode = "console";
		}
		else if (gameMode.equalsIgnoreCase("gui")){
			return ;
		}
		model = theModel;
	}

	public void runGame()
	{
		if (gameMode.equals("console"))
		{
			consoleViews.welcomeText();
		}
	}
}