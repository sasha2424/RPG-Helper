package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Entities.Enemy;
import Entities.Player;
import items.Food;
import items.Armor;
import items.Thing;
import objects.SettlementLoader;
import objects.Village;

/*
 * ALL CURRENT COMMANDS
 * 
 * village []
 * add player <>
 * monster []
 * show monsters
 * show <>
 * attack []
 * attack <>
 * give <>
 * take <>
 * pay []
 * buy []
 * load
 * r
 * 
 * 
 * //TODO add Velvet
 * 
 * //TODO fix perseption -> perception
 */

public class Main {
	private static Scanner in;

	public static ArrayList<Player> players;

	public static ArrayList<Enemy> enemies;

	private static final String RACES = "ork, human, and elf";

	public static void main(String[] args) {
		in = new Scanner(System.in);
		players = new ArrayList<Player>();
		enemies = new ArrayList<Enemy>();

		Thing.loadAll();
		SettlementLoader.loadAll();

		System.out.println("RPG HELPER");

		String s = in.nextLine();

		while (s != "exit") {

			if (s.length() > 10 && s.substring(0, 10).equals("add player")) {
				Player p = new Player(s.substring(11));
				System.out.println("What race " + RACES);
				p.setRace(in.nextLine());
				players.add(p);
				System.out.println("Player Added :" + players.get(players.size() - 1).name);
			}

			if (s.length() > 7 && s.substring(0, 7).equals("village")) {
				s = s.substring(8);
				new Village(s.substring(s.indexOf(" ")), Integer.parseInt(s.substring(0, s.indexOf(" "))));
			}
			if (s.length() > 7 && s.substring(0, 7).equals("monster")) {
				enemies.add(new Enemy(Integer.parseInt(s.substring(8))));
				System.out.println(enemies.get(enemies.size() - 1));
			}
			if (s.equals("show monsters")) {
				for (Enemy e : enemies) {
					System.out.println(e + "\n");
				}
			}

			if (s.length() > 5 && s.substring(0, 5).equals("show ")) {
				String a = s.substring(5);
				if (playerIndex(a) != -1) {
					System.out.println(players.get(playerIndex(a)).toString());
				}
			}
			if (s.length() > 7 && s.substring(0, 7).equals("attack ")) {
				String a = s.substring(7);

				int attack = 0;
				if (playerIndex(a) != -1) {
					attack = players.get(playerIndex(a)).attack("\t");
				} else {
					attack = enemies.get(Integer.parseInt(a)).attack("\t");
				}

				System.out.println("\t" + "Attack: " + attack);
			}

			if (s.length() > 5 && s.substring(0, 5).equals("give ")) {
				s = s.substring(5);
				if (playerIndex(s.substring(0, s.indexOf(" "))) != -1) {
					players.get(playerIndex(s.substring(0, s.indexOf(" ")))).give(s.substring(s.indexOf(" ") + 1));
				}
			}
			if (s.length() > 5 && s.substring(0, 5).equals("take ")) {
				s = s.substring(5);
				if (playerIndex(s.substring(0, s.indexOf(" "))) != -1) {
					players.get(playerIndex(s.substring(0, s.indexOf(" ")))).remove(s.substring(s.indexOf(" ") + 1));
				}
			}

			if (s.length() > 4 && s.substring(0, 4).equals("pay ")) {
				s = s.substring(4);
				if (playerIndex(s.substring(0, s.indexOf(" "))) != -1) {
					players.get(playerIndex(s.substring(0, s.indexOf(" ")))).gold += Integer
							.parseInt(s.substring(s.indexOf(" ") + 1));
				}
			}
			if (s.length() > 4 && s.substring(0, 4).equals("buy ")) {
				s = s.substring(4);
				if (playerIndex(s.substring(0, s.indexOf(" "))) != -1) {
					players.get(playerIndex(s.substring(0, s.indexOf(" ")))).gold -= Integer
							.parseInt(s.substring(s.indexOf(" ") + 1));
				}
			}
			if (s.equals("r")) {
				System.out.println(Math.random());
			}
			if (s.equals("load")) {
				Thing.loadAll();
			}
			if (Thing.getThing(s) != null) {
				System.out.println(Thing.getThing(s));
			}
			s = in.nextLine();
		}
	}

	public static int playerIndex(String a) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).name.equals(a)) {
				return i;
			}
		}
		return -1;
	}

}
