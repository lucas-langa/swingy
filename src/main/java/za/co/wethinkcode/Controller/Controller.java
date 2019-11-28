package za.co.wethinkcode.Controller;
import za.co.wethinkcode.views.ConsoleViews;
import za.co.wethinkcode.views.DisplayInterface;
import 	za.co.wethinkcode.model.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	private Model model;
	// private view view;
	private DisplayInterface Views;
	private String gameMode;

	public static void main(String[] args) {
		Model model = new Model();
		DisplayInterface Views= new ConsoleViews();
		Controller gamecontroller = new Controller(model, Views, "console");

	}

	public Controller(Model theModel, DisplayInterface theconsoleViews, String gameMode) {
		this.model = theModel;
		if (gameMode.equalsIgnoreCase("console")) {
			Views = theconsoleViews;
			gameMode = "console";
		} else if (gameMode.equalsIgnoreCase("gui")) {
			return;
		}
		model = theModel;
	}

	class ViewListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			e.getActi         vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv                 vonCommand()

		}

	}
	public void runGame()
	{
		if (gameMode.equals("console"))
		{
			consoleViews.welcomeText();
		}
	}
}