package za.co.wethinkcode.views;

import javax.swing.*;
import javax.validation.ConstraintViolation;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

import za.co.wethinkcode.GameMap;
import za.co.wethinkcode.model.heroes.Hero;

public class GUIViews extends JFrame implements DisplayInterface {
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
	private JTextArea guiMap; 
	private JButton up = new JButton("n");
	private JButton down = new JButton("s");
	private JButton left = new JButton("w");
	private JButton right = new JButton("e"); 
	private JTextArea errors = new JTextArea();
	private JTextArea encounterText;
	private JButton saveNewHero = new JButton("saveNewHero");
	private JButton fight = new JButton("fight");
	private JButton flee = new JButton("flee");


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
		saveNewHero.addActionListener(GUIButtons);
		up.addActionListener(GUIButtons);
		down.addActionListener(GUIButtons);
		left.addActionListener(GUIButtons);
		right.addActionListener(GUIButtons);
		fight.addActionListener(GUIButtons);
		flee.addActionListener(GUIButtons);
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

	public void fightSim  () {

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

	public void updateMap(GameMap map){
		mainPanel.remove(guiMap);
		clearScreen();
		displayMap(map);
		clearScreen();
	}

	public void removeEncounterText(){
		mainPanel.remove(encounterText);
	}
	
	public void welcomeText() {
		heroSelectionLabel.setBounds(100, 100, 100, 100);
		heroCreationLabel.setBounds(100, 100, 100, 100);
		greeting.setBounds(100, 100, 100, 100);
		mainPanel.add(greeting);
		mainPanel.add(heroCreationLabel);
		mainPanel.add(heroSelectionLabel);
	}

	public void displayMap(GameMap map) {
		guiMap = new JTextArea(null,null,map.getSize(),map.getSize());
		guiMap.setFont(guiMap.getFont().deriveFont(20f));
		for (int i = 0; i < map.getSize() ; i++){
			for (int j = 0; j < map.getSize(); j++) {
				guiMap.append(Character.toString((char)map.map[i][j]));
			}
			guiMap.append("\n");
		}
		mainPanel.add(guiMap);
	}

	public void  setupGameView(GameMap map){
		mainPanel.removeAll();
		clearScreen();
		displayMap(map);
		mainPanel.add(up);
		mainPanel.add(down);
		mainPanel.add(left);
		mainPanel.add(right);
	}
	
	@Override
	public void forceNewHero() {
		newHeroName();
		newHeroClass();
	}

	@Override
	public void displayPlayerVictory() {
		JOptionPane.showMessageDialog(mainPanel, "You defeated the villain ^^", "Battle Outcome", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void displayBattleLoss(int health) {
		// (void)health;
		JOptionPane.showMessageDialog(mainPanel, "You were brutalised and obviously lost, better luck next time", "Battle Outcome", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void gameOver() {
		JOptionPane.showMessageDialog(mainPanel, "The game has ended", "Game over", JOptionPane.WARNING_MESSAGE);

	}

	@Override
	public void displayEscapeFailure() {
		JOptionPane.showMessageDialog(mainPanel, "You failed to escape and were forced to fight", "Fight or Flee", JOptionPane.INFORMATION_MESSAGE);

	}

	@Override
	public void displayEscapeSuccess() {
		JOptionPane.showMessageDialog(mainPanel, "You Managed to escape this time ^^", "Fight or Flee", JOptionPane.INFORMATION_MESSAGE);

	}

	@Override
	public void displayVictoryScreen(String heroName) {
		JOptionPane.showMessageDialog(mainPanel, "You won the game ^^", "Game Over", JOptionPane.INFORMATION_MESSAGE);

	}


	@Override
	public void encounterText() {
		encounterText = new JTextArea("You have encountered an enemy, what do you do?");
		mainPanel.add(encounterText);
		mainPanel.add(fight);
		mainPanel.add(flee);
	}

	public void disableButtons()
	{
		this.up.setEnabled(false);
		this.down.setEnabled(false);
		this.left.setEnabled(false);
		this.right.setEnabled(false);
	}

	public void enableButtons(){
		up.setEnabled(true);
		down.setEnabled(true);
		left.setEnabled(true);
		right.setEnabled(true);
	}

	public void disableEncounterActions(){
		fight.setEnabled(false);
		flee.setEnabled(false);
	}

	public void enableEncounterActions(){
		fight.setEnabled(true);
		flee.setEnabled(true);
	}
}