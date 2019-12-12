package za.co.wethinkcode;

import za.co.wethinkcode.Controller.Controller;
import za.co.wethinkcode.model.Model;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Swingy {
	public static EntityManagerFactory ENTITY_MANAGER_FACTORY =
	Persistence.createEntityManagerFactory("za.co.wethinkcode.Swingy");
	public static void main(String[] args) {
		Model model = new Model();
		new Controller(model, "gui");
	}
}
