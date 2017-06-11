package objects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Room {

	public String name;
	public double spawn;
	public int level;
	public String gens;

	public ArrayList<Object> furniture;

	public Room(String s) {

		String[] t = s.split(",");
		name = t[0];
		spawn = Double.parseDouble(t[1]);
		level = Integer.parseInt(t[2]);
		gens = t[3];
	}

	public Room() {
		furniture = new ArrayList<Object>();
	}

	public static Room getRoom(String name, int level) {
		Room temp = SettlementLoader.getRoom(name);
		Room room = new Room();
		room.name = name;
		room.spawn = temp.spawn;
		room.level = temp.level;
		room.gens = temp.gens;

		for (int i = 0; i < level * Math.random() || room.furniture.size() < 1; i++) {
			Object o = SettlementLoader.allFurniture.get((int) (Math.random() * SettlementLoader.allFurniture.size()));
			if (room.gens.contains(o.name) && Math.random() < o.spawn && o.level <= level) {
				room.furniture.add(Object.getObject(o.name, level));
			}
			if (!(o.level <= level)) {
				i--;
			}
		}

		return room;
	}

	public String toString() {
		String s = "";
		s += "      " + name + System.lineSeparator();
		for (Object o : furniture) {
			s += "      " + o.toString() + System.lineSeparator();
		}
		return s;
	}

}
