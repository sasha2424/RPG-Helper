package objects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Building {

	public String name;
	public double spawn;
	public int level;
	public String gens;

	public ArrayList<Room> rooms;

	public Building(String s) {

		String[] t = s.split(",");
		name = t[0];
		spawn = Double.parseDouble(t[1]);
		level = Integer.parseInt(t[2]);
		gens = t[3];
	}

	public Building() {
		rooms = new ArrayList<Room>();
	}

	public static Building getBuilding(String name, int level) {
		Building temp = SettlementLoader.getBuilding(name);
		Building b = new Building();
		b.name = name;
		b.spawn = temp.spawn;
		b.level = temp.level;
		b.gens = temp.gens;

		for (int i = 0; i < b.level * Math.random() || b.rooms.size() < level / 3; i++) {
			Room r = SettlementLoader.allRooms.get((int) (Math.random() * SettlementLoader.allRooms.size()));
			if (b.gens.contains(r.name) && Math.random() < r.spawn && r.level <= level) {
				b.rooms.add(Room.getRoom(r.name, level));
			}

			if (!(r.level <= level)) {
				i--;
			}
		}

		return b;
	}

	public String toString() {
		String s = "";
		s += "   " + name + System.lineSeparator();
		for (Room r : rooms) {
			s += "   " + r.toString() + System.lineSeparator();
		}
		return s;
	}

}
