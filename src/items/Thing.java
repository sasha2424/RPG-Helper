package items;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Thing {

	public String name;
	public int level;
	public double spawn;

	public static ArrayList<Clothes> clothes;
	public static ArrayList<Armor> armor;
	public static ArrayList<Food> food;
	public static ArrayList<Weapon> weapons;

	public static void loadAll() {
		clothes = new ArrayList<Clothes>();
		armor = new ArrayList<Armor>();
		food = new ArrayList<Food>();
		weapons = new ArrayList<Weapon>();
		loadClothes();
		loadArmor();
		loadFood();
		loadWeapons();
	}

	public static Thing getRandomThing(int level) {
		if (Math.random() < .25) {
			return randomClothes(level);
		} else if (Math.random() < .5) {
			return randomArmor(level);
		} else if (Math.random() < .75) {
			return randomWeapon(level);
		} else {
			return randomFood(level);
		}

	}

	public static Thing getThing(String name) {
		for (Thing i : armor) {
			if (i.name.equals(name)) {
				return i;
			}
		}
		for (Thing i : weapons) {
			if (i.name.equals(name)) {
				return i;
			}
		}
		for (Thing i : clothes) {
			if (i.name.equals(name)) {
				return i;
			}
		}
		for (Thing i : food) {
			if (i.name.equals(name)) {
				return i;
			}
		}
		return null;
	}

	public static Clothes randomClothes(int level) {
		double total = 0;
		for (Clothes i : clothes) {
			if (i.level <= level) {
				total += i.spawn;
			}
		}
		double r = total * Math.random();
		for (Clothes i : clothes) {
			if (i.level <= level) {
				r -= i.spawn;
			}
			if (r <= 0) {
				return i;
			}
		}
		return null;
	}

	public static Armor randomArmor(int level) {
		double total = 0;
		for (Armor i : armor) {
			if (i.level <= level) {
				total += i.spawn;
			}
		}
		double r = total * Math.random();
		for (Armor i : armor) {
			if (i.level <= level) {
				r -= i.spawn;
			}
			if (r <= 0) {
				return i;
			}
		}
		return null;
	}

	public static Weapon randomWeapon(int level) {
		double total = 0;
		for (Weapon i : weapons) {
			if (i.level <= level) {
				total += i.spawn;
			}
		}
		double r = total * Math.random();
		for (Weapon i : weapons) {
			if (i.level <= level) {
				r -= i.spawn;
			}
			if (r <= 0) {
				return i;
			}
		}
		return null;
	}

	public static Food randomFood(int level) {
		double total = 0;
		for (Food i : food) {
			if (i.level <= level) {
				total += i.spawn;
			}
		}
		double r = total * Math.random();
		for (Food i : food) {
			if (i.level <= level) {
				r -= i.spawn;
			}
			if (r <= 0) {
				return i;
			}
		}
		return null;
	}

	public static void loadClothes() {
		String s = "";
		try (BufferedReader br = new BufferedReader(new FileReader("./Data/clothes.txt"))) {
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

		for (int i = 0; i < k.length; i++) {
			clothes.add(new Clothes(k[i]));
		}
	}

	public static void loadWeapons() {
		String s = "";
		try (BufferedReader br = new BufferedReader(new FileReader("./Data/weapons.txt"))) {
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

		for (int i = 0; i < k.length; i++) {
			weapons.add(new Weapon(k[i]));
		}
	}

	public static void loadArmor() {
		String s = "";
		try (BufferedReader br = new BufferedReader(new FileReader("./Data/armor.txt"))) {
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

		for (int i = 0; i < k.length; i++) {
			armor.add(new Armor(k[i]));
		}
	}

	public static void loadFood() {

		String s = "";
		try (BufferedReader br = new BufferedReader(new FileReader("./Data/food.txt"))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				// sb.append(System.lineSeparator());
				line = br.readLine();
			}
			s = sb.toString();
		} catch (

		FileNotFoundException e)

		{
			e.printStackTrace();
		} catch (

		IOException e)

		{
			e.printStackTrace();
		}

		String[] k = s.split(";");

		for (int i = 0; i < k.length; i++)

		{
			food.add(new Food(k[i]));
		}
	}
}
