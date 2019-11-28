package za.co.wethinkcode.views;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.validation.ConstraintViolation;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import za.co.wethinkcode.model.Model;
import za.co.wethinkcode.heroes.Hero;

public class GUIViews extends JFrame implements DisplayInterface {
	private JPanel mainPanel, mainFrame;
	private JButton confirmClass, heroSelectionLabel, heroCreationLabel;
	private JList<String> heroList, playerClassList;
	private JLabel greeting,heroName, heroClass, heroAttack, heroDefense, heroExperience, heroHitPoints, heroLevel, classLabel;
	private JTextField playerName;
	private JScrollPane classScrollPane;
	private String[] classes = { "Damage", "Tank", "Flank" };

	public String 	getHeroClass() {
		return(classes[playerClassList.getSelectedIndex()]);
	}

	public void newHeroClass() {
		this.classLabel = new JLabel("Hero Class: ");
		this.confirmClass = new JButton("ok");
		// String[] classes = { "Damage", "Tank", "Flank" };

		this.playerClassList = new JList<String>(classes);
		this.playerClassList.setVisibleRowCount(3);
		this.classScrollPane = new JScrollPane(this.playerClassList);
		this.playerClassList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
	}

	public void communicator(ActionListener ActionListener) {
		heroCreationLabel.addActionListener(ActionListener);
		heroSelectionLabel.addActionListener(ActionListener);
	}

	public static void main(String[] args) {
		Model heroModel = new Model();
		GUIViews gui = new GUIViews();
		gui.welcomeText();
		// gui.newHeroClass();
		// List<Hero> heroes = heroModel.getHeroesFromDB();
		// gui.selectHero(heroes);
		// gui.peasantStats(heroes.get(0));
		// gui.newHeroClass();
	}

	public void newHeroName(String name) {
		playerName.setText(name);
	}

	public void getHeroName(){
		playerName.getText();
	}

	public void fightSim() {

	}

	public void peasantStats(Hero peasant) {
		JLabel[] stats = {
				this.heroName = new JLabel("<html><p>Hero Name " + peasant.getHeroName() + "</p></html>",
						SwingConstants.LEFT),
				this.heroClass = new JLabel("<html><p>Hero Class " + peasant.getHeroClass() + "</p></html>",
						SwingConstants.LEFT),
				this.heroAttack = new JLabel("<html><p>Hero Attack " + peasant.getHeroAttack() + "</p></html>",
						SwingConstants.LEFT),
				this.heroDefense = new JLabel("<html><p>Hero Defense " + peasant.getHeroDefense() + "</p></html>",
						SwingConstants.LEFT),
				this.heroExperience = new JLabel(
						"<html><p>Hero Experience " + peasant.getHeroExperience() + "</p></html>", SwingConstants.LEFT),
				this.heroHitPoints = new JLabel(
						"<html><p>Hero Hit Points " + peasant.getHeroHitPoints() + "</p></html>", SwingConstants.LEFT),
				this.heroLevel = new JLabel("<html><p>Hero Level " + peasant.getHeroLevel() + "</p></html>",
						SwingConstants.LEFT) };
		for (JLabel jLabel : stats) {
			mainFrame.add(jLabel);
		}
	}

	public void clearScreen() {
		mainFrame.revalidate();
		mainFrame.repaint();
	}

	GUIViews() {
		super("Swingy");
		this.mainFrame = new JPanel();
		mainFrame.setLayout(new FlowLayout());
		super.add(mainFrame);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.pack();
		super.setSize(1024, 768);
		super.setLocationRelativeTo(null);
		super.setVisible(true);

	}

	public void welcomeText() {
		greeting = new JLabel("Welcome to swingy");
		heroCreationLabel = new JButton("1.Create a new Hero");
		heroCreationLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newHeroName();
				clearScreen();
				newHeroClass();
			}
		});

		heroSelectionLabel = new JButton("2.Select an existing Hero");

		mainFrame.add(greeting);
		mainFrame.add(heroCreationLabel);
		mainFrame.add(heroSelectionLabel);
	}

	public void selectHero(List<Hero> heroes) {
		String[] chars = new String[heroes.size()];

		for (int i = 0; i < heroes.size(); i++) {
			chars[i] = heroes.get(i).getHeroName();
		}

		this.heroList = new JList<String>(chars);
		heroList.setVisibleRowCount(2);
		heroList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		this.heroList.setLocation(350, 350);
		this.heroList.setBounds(300, 200, 50, 50);
		this.heroList.setVisible(true);

		mainFrame.add(new JScrollPane(this.heroList));
	}

	public void displayErrors(Set<ConstraintViolation<Hero>> thingsGoneWrong) {
		// TODO Auto-generated method stub
	}

	public void encounterText() {
		// TODO Auto-generated method stub

	}

	public void displayMap(int[][] map, int size) {
		// TODO Auto-generated method stub

	}

	public void divisionExample() {
		// TODO Auto-generated method stub

	}

}