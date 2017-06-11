package objects;

import java.util.ArrayList;

import items.Thing;

public class Object {

	public String name;
	public double spawn;
	public int level;
	public int levelMod;
	public String gens; // A - Armor W - Weapons C - Clothes F - Food D - Chest

	public ArrayList<Thing> things;
	public int gold;

	public Object(String a) {
		things = new ArrayList<Thing>();

		String[] t = a.split(",");
		name = t[0];
		spawn = Double.parseDouble(t[1]);
		level = Integer.parseInt(t[2]);
		levelMod = Integer.parseInt(t[3]);
		gens = t[4];
	}

	public Object() {
		things = new ArrayList<Thing>();
	}

	public static Object getObject(String name, int level) {
		Object temp = SettlementLoader.getFurniture(name);
		Object o = new Object();
		o.name = name;
		o.spawn = temp.spawn;
		o.level = temp.level;
		o.gens = temp.gens;

		if (o.gens.contains("A")) {
			o.generateArmor(o.level);
		}
		if (o.gens.contains("W")) {
			o.generateWeapon(o.level);
		}
		if (o.gens.contains("F")) {
			o.generateFood(o.level);
		}
		if (o.gens.contains("C")) {
			o.generateClothes(o.level);
		}
		if (o.gens.contains("D")) {
			o.generateChest(o.level);
		}

		return o;
	}

	private void generateClothes(int level) {
		for (int i = 0; i < level; i++) {
			things.add(Thing.randomClothes(level));
		}
	}

	private void generateFood(int level) {
		for (int i = 0; i < level; i++) {
			things.add(Thing.randomFood(level));
		}
	}

	private void generateArmor(int level) {
		for (int i = 0; i < level; i++) {
			things.add(Thing.randomArmor(level));
		}

	}

	private void generateWeapon(int level) {
		for (int i = 0; i < level; i++) {
			things.add(Thing.randomWeapon(level));
		}

	}

	private void generateChest(int level) {
		gold = getGold(level);

		for (int i = 0; i < level; i++) {
			double rand = Math.random();
			if (rand < .25) {
				things.add(Thing.randomClothes(level));
			} else if (rand < .5) {
				things.add(Thing.randomArmor(level));
			} else if (rand < .75) {
				things.add(Thing.randomWeapon(level));
			} else {
				things.add(Thing.randomFood(level));
			}
		}
	}

	public static int getGold(int level) {
		int k = 0;
		for (int i = 0; i < Math.random() * 10 * level; i++) {
			k += Math.random() * 10;
		}
		return k;
	}

	public String toString() {
		String s = "";
		s += "         " + name + System.lineSeparator();
		if (gens.contains("D")) {
			s += "                    " + gold + " gold" + System.lineSeparator();
		}
		for (Thing t : things) {
			s += "         " + t.toString() + System.lineSeparator();
		}
		return s;
	}

}
