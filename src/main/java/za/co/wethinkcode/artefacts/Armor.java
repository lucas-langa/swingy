package za.co.wethinkcode.artefacs;

public enum Armor {
	BRA("Bra", 300),
	BRIGSHIELD("Brig's shield", 200),
	ASTHMAINHALER("Breather", 80),
	REGULARSHIELD("ordinary Shield", 50),
	UMBRELLA("True Armor", 20);

	private final String armorName;
	private final int defensePoints;

	Armor( String armorName, int defensePoints) {
		this.armorName = armorName;
		this.defensePoints = defensePoints;
	}

	public String getArmorName() {
		return armorName;
	}

	public int getDefensePoints() {
		return defensePoints;
	}
}
