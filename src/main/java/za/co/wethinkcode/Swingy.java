package za.co.wethinkcode;

import za.co.wethinkcode.Controller.Controller;
import za.co.wethinkcode.model.Model;


public class Swingy {
	public static void main(String args) {
		Model model = new Model();
		new Controller(model, args);
	}
}
