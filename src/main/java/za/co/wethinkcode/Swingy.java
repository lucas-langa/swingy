package za.co.wethinkcode;

import za.co.wethinkcode.model.Model;
import za.co.wethinkcode.views.ConsoleViews;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Swingy {
	public static EntityManagerFactory ENTITY_MANAGER_FACTORY =
	Persistence.createEntityManagerFactory("za.co.wethinkcode.Swingy");
	public static void main(String[] args) {
		ConsoleViews viewConsole = new ConsoleViews();
		Model heroModel = new Model();
		heroModel.addHero("miley", "flank");
	}
}
