package objects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import items.Armor;
import items.Thing;

public class Village {

	public String name;

	public ArrayList<Building> buildings;

	public Village(String name, int level) {
		buildings = new ArrayList<Building>();

		this.name = name;

		for (int i = 0; i < level; i++) {
			Building b = SettlementLoader.allBuildings
					.get((int) (Math.random() * SettlementLoader.allBuildings.size()));

			if (b.level <= level && Math.random() < b.spawn) {
				buildings.add(Building.getBuilding(b.name, level));
			}
			if (!(b.level <= level)) {
				i--;
			}
		}

		save();
	}

	public void save() {
		String s = "";
		s += name + System.lineSeparator();
		for (Building b : buildings) {
			s += b.toString() + System.lineSeparator();
		}

		try {
			PrintWriter writer = new PrintWriter("./Villages/" + name + ".txt");
			writer.println(s);
			writer.close();
		} catch (IOException e) {
			// do something
		}
	}

}
