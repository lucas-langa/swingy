package za.co.wethinkcode.Controller;
import za.co.wethinkcode.views.ConsoleViews;
import 	za.co.wethinkcode.model.Model;

public class Controller {
	private Model model;
	// private view view;
	private ConsoleViews consoleViews;
	private String gameMode;

	public static void main(String[] args) {
		Model model = new Model();
		ConsoleViews consoleViews = new ConsoleViews();
		Controller gamecontroller = new Controller(model, consoleViews, "console");

	}
	public Controller(Model theModel, ConsoleViews theconsoleViews, String gameMode)
	{
		this.model = theModel;
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