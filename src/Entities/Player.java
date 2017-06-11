package Entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import items.Armor;
import items.Thing;
import main.Main;

public class Player {
	public String name;

	public int hp;
	public int xp;
	public int gold;

	public String race;
	public ArrayList<String> inventory;

	// TODO include armor

	public Player(String name) {
		inventory = new ArrayList<String>();
		this.name = name;
		load(name);
	}

	public void takeHit(int a) {
		hp -= a; // TODO include defense;
		System.out.println(name + " took " + a + " damage");
	}

	public void pureHit(int a) {
		hp -= a;
		System.out.println(name + " took " + a + " damage");
	}

	public int attack(String t) {
		double k = Math.random();
		if (k < .05) {
			System.out.println(t + k + "\tCritical Miss");
			hp -= 0;
			return -getLevel();
		}
		if (k < .3) {
			System.out.println(t + k + "\tMiss");
			return 0;
		}
		if (k < .95) {
			System.out.println(t + k + "\tHit");
			return getLevel();
		}
		System.out.println(t + k + "\tCritical Hit");
		return getLevel() * 2;
	}

	public int getLevel() {
		return (int) (Math.sqrt(xp / 2));
	}

	public int getHPMax() {
		return 5 + 5 * getLevel() + getBonuses();
	}

	public int getBonuses() {
		return 0;
	}

	public void setRace(String r) {
		race = r;
	}

	public void give(String s) {
		inventory.add(s);
	}

	public void remove(String s) {
		inventory.remove(s);
	}

	public String toString() {
		String r = "Level: " + getLevel() + "\tHP: " + hp + "\tGold:" + gold;
		for (String s : inventory) {
			r += "\t\n" + Thing.getThing(s).toString();
		}
		return r;

	}

	public void save() {
		try {
			PrintWriter writer = new PrintWriter("./Players/" + name + ".txt");
			writer.println(race + "," + hp + "," + gold + "," + xp + ";");
			for (String s : inventory) {
				writer.println(s + ";");
			}
			writer.close();
		} catch (IOException e) {
			// do something
		}
	}

	public void load(String name) {
		String s = "";
		try (BufferedReader br = new BufferedReader(new FileReader("./Players/" + name + ".txt"))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				// sb.append(System.lineSeparator());
				line = br.readLine();
			}
			s = sb.toString();

			String[] k = s.split(";");
			String[] temp = k[0].split(",");
			race = temp[0];
			hp = Integer.parseInt(temp[1]);
			gold = Integer.parseInt(temp[2]);
			xp = Integer.parseInt(temp[3]);
			for (int i = 1; i < k.length; i++) {
				inventory.add(k[i]);
			}

		} catch (FileNotFoundException e) {
			xp = 1;
			gold = 0;
			hp = 5 + 5 * getLevel();
			race = "human";
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
