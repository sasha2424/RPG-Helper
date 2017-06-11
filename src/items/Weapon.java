package items;

public class Weapon extends Thing {

	public int attack;
	public double perseption;

	public Weapon(String s) {
		String[] p = s.split(",");
		name = p[0];
		attack = Integer.parseInt(p[1]);
		perseption = Double.parseDouble(p[3]);
		spawn = Double.parseDouble(p[4]);
		level = Integer.parseInt(p[5]);
	}

	public String toString() {
		return "            " + name + "\tA: " + attack + "\tPerseption: " + perseption;
	}
}
