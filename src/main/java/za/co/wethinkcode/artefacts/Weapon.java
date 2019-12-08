package za.co.wethinkcode.artefacts;

public enum Weapon {
	SWORD("Escalibur", 30),
	GUN("Desert Eagle", 25),
	SPEAR("Shaka", 31),
	STONE("OfSand", 5),
	ROCK("DWAYNETHEROCK", 1);

	private final String name;
	private final int AttackPoints;

	Weapon ( String weaponName, int attackPoints ){
		this.name = weaponName;
		this.AttackPoints = attackPoints;
	}

	public int getAttackPoints() {
		return AttackPoints;
	}

	public String getName() {
		return name;
	}
}
