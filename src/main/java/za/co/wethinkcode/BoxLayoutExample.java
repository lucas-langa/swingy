package za.co.wethinkcode;

import java.awt.*;
import java.lang.reflect.Array;

import javax.swing.*;

public class BoxLayoutExample extends Frame {
	Button buttons[] = new Button[5];

	public BoxLayoutExample() {
		buttons = new Button[3];
		String heros[] = {"Flanker","Damage","Tank"};

		for (int i = 0; i < 3; i++) {
			buttons[i] = new Button(heros[i]);
			add(buttons[i]);
		}

		setTitle("Select a Hero Class");
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setSize(400, 400);
		setVisible(true);
	}

	public static void main(String args[]) {
		BoxLayoutExample b = new BoxLayoutExample();
	}
}