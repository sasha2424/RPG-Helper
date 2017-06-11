package objects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SettlementLoader {

	public static ArrayList<Building> allBuildings;
	public static ArrayList<Room> allRooms;
	public static ArrayList<Object> allFurniture;

	public static void loadAll() {
		loadBuildings();
		loadRooms();
		loadFurniture();
	}

	public static Building getBuilding(String s) {
		for (Building b : allBuildings) {
			if (b.name.equals(s)) {
				return b;
			}
		}
		return null;
	}

	// TODO change the letters
	public static Room getRoom(String s) {
		for (Room b : allRooms) {
			if (b.name.equals(s)) {
				return b;
			}
		}
		return null;
	}

	public static Object getFurniture(String s) {
		for (Object b : allFurniture) {
			if (b.name.equals(s)) {
				return b;
			}
		}
		return null;
	}

	public static void loadBuildings() {
		String s = "";
		try (BufferedReader br = new BufferedReader(new FileReader("./Data/Settlements/buildings.txt"))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				// sb.append(System.lineSeparator());
				line = br.readLine();
			}
			s = sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] k = s.split(";");

		allBuildings = new ArrayList<Building>();

		for (int i = 0; i < k.length; i++) {
			allBuildings.add(new Building(k[i]));
		}
	}

	public static void loadRooms() {
		String s = "";
		try (BufferedReader br = new BufferedReader(new FileReader("./Data/Settlements/rooms.txt"))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				// sb.append(System.lineSeparator());
				line = br.readLine();
			}
			s = sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] k = s.split(";");

		allRooms = new ArrayList<Room>();

		for (int i = 0; i < k.length; i++) {
			allRooms.add(new Room(k[i]));
		}
	}

	public static void loadFurniture() {
		String s = "";
		try (BufferedReader br = new BufferedReader(new FileReader("./Data/Settlements/furniture.txt"))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				// sb.append(System.lineSeparator());
				line = br.readLine();
			}
			s = sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] k = s.split(";");

		allFurniture = new ArrayList<Object>();

		for (int i = 0; i < k.length; i++) {
			allFurniture.add(new Object(k[i]));
		}
	}

}
