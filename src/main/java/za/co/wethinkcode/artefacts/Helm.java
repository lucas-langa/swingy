package za.co.wethinkcode.artefacts;

public enum Helm {
	NANOBOOST("Get in There", 1000),
	BLUEBEAM("Mercy's Right click", 100),
	DISCORDORB("discord orb", 200),
	INFRASIGHT("something useless", 10);

	private final String helmName;
	private final int hitPoints;

	Helm( String helmName, int hitPoints ){
		this.helmName = helmName;
		this.hitPoints = hitPoints;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public String getHelmName() {
		return helmName;
	}
}
