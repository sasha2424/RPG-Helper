package items;

public class Clothes extends Thing {

	public double perception;

	public Clothes(String s) {
		String[] p = s.split(",");
		name = p[0];
		perception = Double.parseDouble(p[1]);
		spawn = Double.parseDouble(p[2]);
		level = Integer.parseInt(p[3]);
	}

	public String toString() {
		return "            " + name + "\tPerception: " + perception;
	}
}
