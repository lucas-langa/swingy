package za.co.wethinkcode.views;

import javax.swing.*;
import javax.validation.ConstraintViolation;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

import za.co.wethinkcode.GameMap;
import za.co.wethinkcode.heroes.Hero;

public class GUIViews extends JFrame implements DisplayInterface {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JButton confirmClass = new JButton("ConfirmClass");
	private JList<String> heroList, playerClassList;
	private JButton heroSelectionLabel = new JButton("2.Select an existing Hero");
	private JButton heroCreationLabel = new JButton("1.Create a new Hero");
	private JLabel greeting = new JLabel("Welcome to swingy");
	private JLabel heroName, heroClass, heroAttack, heroDefense, heroExperience, heroHitPoints, heroLevel, classLabel;
	private JTextField playerName = new JTextField(20);
	private JButton confirmPlayerName = new JButton("confirmPlayerName");
	private final String[] classes = { "Damage", "Tank", "Flank" };
	private JTextArea gameMap;
	private JButton confirmDbHero = new JButton("confirmDbHero");
	private Hero chosenOne = null;
	private List<Hero> heroes;
	private JLabel[] stats = new JLabel[7];
	private JButton ShowHeroStats = new JButton("ShowHeroStats");
	private JTextArea guiMap = new JTextArea();
	private JButton gimmeMap = new JButton("gimmeMap");
	private JButton up = new JButton("n");
	private JButton down = new JButton("s");
	private JButton left = new JButton("w");
	private JButton right = new JButton("e");
	private JTextArea errors = new JTextArea();
	private JButton saveNewHero = new JButton("saveNewHero");

	public void displayErrors(Set<ConstraintViolation<Hero>> thingsGoneWrong){
		for (ConstraintViolation<Hero> constraintViolation : thingsGoneWrong) {
			errors.append(constraintViolation.getMessage());
		}
		mainPanel.add(errors);
	}

	public String getPlayerClass() {
		return (classes[playerClassList.getSelectedIndex()]);
	}

	@Override
	public Hero getChosenOne() {
		return this.chosenOne = heroes.get(heroList.getSelectedIndex());
	}

	public void selectHero(List<Hero> heroes) {
		mainPanel.remove(greeting);
		mainPanel.remove(heroCreationLabel);
		mainPanel.remove(heroSelectionLabel);

		String[] chars = new String[heroes.size()];
		this.heroes = heroes;
		for (int i = 0; i < heroes.size(); i++) {
			chars[i] = heroes.get(i).getHeroName();
		}

		this.heroList = new JList<String>(chars);
		heroList.setVisibleRowCount(2);
		heroList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.heroList.setLocation(350, 350);
		this.heroList.setBounds(300, 200, 50, 50);
		this.heroList.setVisible(true);
		mainPanel.add(new JScrollPane(this.heroList));
		mainPanel.add(ShowHeroStats);
		mainPanel.add(confirmDbHero);
	}

	public void newHeroClass() {
		this.classLabel = new JLabel("Hero Class: ");
		this.playerClassList = new JList<String>(classes);
		this.playerClassList.setVisibleRowCount(3);

		mainPanel.add(classLabel);
		mainPanel.add(confirmClass);
		mainPanel.add(playerClassList);
		mainPanel.add(saveNewHero);
	}

	public void displayError(String error){
		JOptionPane.showMessageDialog(mainPanel, error, "not like this", JOptionPane.ERROR_MESSAGE);
	}

	public void communicator(ActionListener GUIButtons) {
		confirmPlayerName.addActionListener(GUIButtons);
		confirmClass.addActionListener(GUIButtons);
		heroCreationLabel.addActionListener(GUIButtons);
		heroSelectionLabel.addActionListener(GUIButtons);
		confirmDbHero.addActionListener(GUIButtons);
		ShowHeroStats.addActionListener(GUIButtons);
		gimmeMap.addActionListener(GUIButtons);
		saveNewHero.addActionListener(GUIButtons);
	}

	public void newGameView() {
		mainPanel.remove(greeting);
		mainPanel.remove(heroCreationLabel);
		mainPanel.remove(heroSelectionLabel);
		clearScreen();
		newHeroName();
		newHeroClass();
	}

	public void newHeroName() {
		mainPanel.add(playerName);
		mainPanel.add(confirmPlayerName);
	}

	@Override
	public String getPlayerName() {
		return playerName.getText();
	}

	public void makeMap(GameMap map){
		guiMap.setFont(guiMap.getFont().deriveFont(20f));
		for (int i = 0; i < map.heroX ; i++){
			for (int j = 0; j < map.heroX; j++) {
				guiMap.append(Character.toString(map.map[i][j]));
			}
			guiMap.append("\n");
		}
		mainPanel.add(guiMap);
	}

	public void fightSim() {

	}

	public void peasantStats(Hero peasant) {
		JTextArea stat = new JTextArea();
		stats[0] = this.heroName = new JLabel("Hero Name " + peasant.getHeroName() + "\n", SwingConstants.LEFT);
		stats[1] = this.heroClass = new JLabel("Hero Class " + peasant.getHeroClass() + "\n", SwingConstants.LEFT);
		stats[2] = this.heroAttack = new JLabel("Hero Attack " + peasant.getHeroAttack() + "\n", SwingConstants.LEFT);
		stats[3] = this.heroDefense = new JLabel("Hero Defense " + peasant.getHeroDefense() + "\n",
				SwingConstants.LEFT);
		stats[4] = this.heroExperience = new JLabel("Hero Experience " + peasant.getHeroExperience() + "\n",
				SwingConstants.LEFT);
		stats[5] = this.heroHitPoints = new JLabel("Hero Hit Points " + peasant.getHeroHitPoints() + "\n",
				SwingConstants.LEFT);
		stats[6] = this.heroLevel = new JLabel("Hero Level " + peasant.getHeroLevel() + "\n", SwingConstants.LEFT);
		clearScreen();
		for (JLabel jLabel : stats) {
			stat.append(jLabel.getText());
		}
		mainPanel.add(stat);
	}

	public void removePeasantStats() {
		for (JLabel jLabel : stats) {
			mainPanel.remove(jLabel);
		}
		clearScreen();
	}

	public void clearScreen() {
		mainPanel.revalidate();
		mainPanel.removeAll();
		this.revalidate();
		this.repaint();
		mainPanel.repaint();
	}

	public GUIViews() {
		super("Swingy");
		mainPanel = new JPanel();
		this.setSize(1024, 768);
		this.add(mainPanel);
		this.setLocationRelativeTo(null);
		mainPanel.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void welcomeText() {

		heroSelectionLabel.setBounds(100, 100, 100, 100);
		heroCreationLabel.setBounds(100, 100, 100, 100);
		greeting.setBounds(100, 100, 100, 100);
		mainPanel.add(greeting);
		mainPanel.add(heroCreationLabel);

		mainPanel.add(heroSelectionLabel);
		mainPanel.add(gimmeMap);
	}

	public void populateMap(int y, int x) {
		gameMap = new JTextArea();
		gameMap.setText("\n");
		for (int i = 0; i < y; i++) {
			gameMap.append("   ");
			for (int j = 0; j < x; j++) {
				gameMap.append("*");
			}
			gameMap.append("\n\r");
		}
		mainPanel.add(gameMap);
	}

	public void displayMap(int[][] map, int size) {
		int y = size, x = size;
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				System.out.printf("%c", map[i][j]);
			}
			System.out.print("\n");
		}
	}

	@Override
	public void forceNewHero() {
		newHeroName();
		newHeroClass();
	}

	@Override
	public void displayPlayerVictory() {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayBattleLoss(int health) {
		// TODO Auto-generated method stub

	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayEscapeFailure() {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayEscapeSuccess() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getAction() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void displayVictoryScreen(String heroName) {
		// TODO Auto-generated method stub

	}

	public void encounterText() {
		// TODO Auto-generated method stub
	}

}