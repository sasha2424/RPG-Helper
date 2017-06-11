package items;

public class Food extends Thing {

	public int hp;

	public Food(String s) {
		String[] p = s.split(",");
		name = p[0];
		hp = Integer.parseInt(p[1]);
		spawn = Double.parseDouble(p[2]);
		level = Integer.parseInt(p[3]);
	}

	public String toString() {
		return "            " + name + "\tHP: " + hp;
	}
}
