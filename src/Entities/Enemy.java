package Entities;

import java.util.ArrayList;

import items.Armor;
import items.Thing;
import items.Weapon;
import main.Main;

public class Enemy {

	public int gold;
	public int hp;
	public int defense;
	public int level;
	public Weapon weapon;
	public ArrayList<Thing> inventory;

	public Enemy(int level) {
		inventory = new ArrayList<Thing>();
		level += 1;
		this.level = level;
		gold = getGold(level);
		hp = 5 + 5 * level;
		defense = (int) (Math.random() * level);
		weapon = (Weapon) Thing.randomWeapon(level);
		for (int i = 0; i < level * Math.random(); i++) {
			inventory.add(Thing.getRandomThing(level));
		}
	}

	public int attack(String t) {
		double k = Math.random();
		if (k < .05) {
			System.out.println(t + "Critical Miss");
			hp -= weapon.attack;
			return 0;
		}
		if (k < .3) {
			System.out.println(t + "Miss");
			return 0;
		}
		if (k < .95) {
			System.out.println(t + "Hit");
			return weapon.attack + level;
		}
		System.out.println(t + "Critical Hit");
		return weapon.attack + level * 2;
	}

	public String toString() {
		String r = "Level: " + level + "\tHP: " + hp + "\tD: " + defense + "\tGold:" + gold + "\n\t"
				+ weapon.toString();
		for (Thing i : inventory) {
			r += "\n\t" + i.toString();
		}
		return r;

	}

	public static int getGold(int level) {

		int k = 0;
		for (int i = 0; i < Math.random() * 5 * level; i++) {
			k += 10;
		}
		return (int) (k + Math.random() * 10);
	}

}
