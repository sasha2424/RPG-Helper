package items;

public class Armor extends Thing {

	public int defense;
	public double perseption;

	public Armor(String s) {
		String[] p = s.split(",");
		name = p[0];
		defense = Integer.parseInt(p[2]);
		perseption = Double.parseDouble(p[3]);
		spawn = Double.parseDouble(p[4]);
		level = Integer.parseInt(p[5]);
	}

	public String toString() {
		return "            " + name + "\tD: " + defense + "\tPerseption: " + perseption;
	}
}
