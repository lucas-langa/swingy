package za.co.wethinkcode.Controller;
import java.awt.event.ActionListener;
import za.co.wethinkcode.views.ConsoleViews;
import 	za.co.wethinkcode.model.Model;

public class Controller {
	private Model model;
	// private view view;
	private ConsoleViews consoleViews;

	public Controller(Model theModel, ConsoleViews theconsoleViews)
	{
		model = theModel;
		consoleViews = theconsoleViews;
	}
		
}