package jet.ikebaana.model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import jet.ikebaana.controller.IkebaanaGo;

public class IkebaanaMetods {
	public static ArrayList<Integer> winArray = new ArrayList<Integer>();

	public static boolean check() {
		boolean newGame = true;
		Scanner scanner = new Scanner(System.in);
		do {
			String answer = scanner.nextLine();
			switch (answer.toUpperCase()) {
			case "Y":
				return true;
			case "N":
				return false;
			default:
				System.out.println("Некорректное значение!");
				break;
			}
		} while (newGame == true);
		scanner.close();
		return newGame;
	}

	public static void step(boolean firstStep) {
		ArrayList<Integer> ikebanaArray = new ArrayList<Integer>();
		boolean isIsPlayersStep = firstStep;
		for (int i = 0; i < 4; i++) {
			winArray.add(3);
		}
		if (firstStep) {
			System.out.println("Ходите!");

			while (!(ikebanaArray.equals(winArray))) {
				isIsPlayersStep = stepPlayer();
				if (!(ikebanaArray.equals(winArray))) {
					isIsPlayersStep = stepComp();
				}
			}
		} else {
			System.out.println("ход Икебанолога Пер-Дака!");
			while (!(ikebanaArray.equals(winArray))) {
				isIsPlayersStep = stepComp();
			}
			if (!(ikebanaArray.equals(winArray))) {
				isIsPlayersStep = stepPlayer();
			}

		}

		for (Integer value : IkebaanaGo.ikebaana.values()) {
			ikebanaArray.add(value);
			System.out.println(value);
		}

	}

	public static boolean stepComp() {

		return false;

	}

	private static String colorChoose() {
		String blue = "синие (нажмите b) ";
		String yellow = "желтые (нажмите y) ";
		String green = "зеленые (нажмите g) ";
		String violet = "фиолетовые (нажмите v) ";

		String choose = "";
		if (IkebaanaGo.ikebaana.get("blue") == 3) {
			blue = "";
		}
		if (IkebaanaGo.ikebaana.get("yellow") == 3) {
			yellow = "";
		}
		if (IkebaanaGo.ikebaana.get("green") == 3) {
			green = "";
		}
		if (IkebaanaGo.ikebaana.get("violet") == 3) {
			violet = "";
		}
		System.out.println("какого цвета цветы Вы хотите добавить?/n");
		System.out.println("" + blue + yellow + green + violet);

		boolean sp = true;
		Scanner scanner = new Scanner(System.in);
		do {
			String answer = scanner.nextLine();

			switch (answer.toUpperCase()) {
			case "B":
				if (blue.equals("")) {
					System.out.println("Некорректное значение!");
					break;
				} else {
					scanner.close();
					return "blue";

				}
			case "Y":
				if (yellow.equals("")) {
					System.out.println("Некорректное значение!");
					break;
				} else {
					scanner.close();
					return "yellow";
				}
			case "G":
				if (green.equals("")) {
					System.out.println("Некорректное значение!");
					break;
				} else {
					scanner.close();
					return "green";
				}
			case "V":
				if (violet.equals("")) {
					System.out.println("Некорректное значение!");
					break;
				} else {
					scanner.close();
					return "violet";

				}
			default:
				System.out.println("Некорректное значение!");
				break;
			}
		} while (sp == true);
		scanner.close();
		return choose;

	}
	
	
	private static int countChoose(String choose) {
		int count= 3 - IkebaanaGo.ikebaana.get(choose);
		System.out.println(count);
		String write = "";
		for (int i = 0; i <count; i++) {
			write= write +","+(i+1)+" ";
		}
		
		System.out.println("Сколько цветов Вы хотите добавть/n");
		System.out.println("наберите "+ write );
		
		boolean sp = true;
		Scanner scanner = new Scanner(System.in);
		do {
			try {
			String answer = scanner.nextLine();

			int tmp = Integer.parseInt(answer);


				if (tmp>=count|| tmp<=0) {
					System.out.println("Некорректное значение!");
					break;
				} else {
					scanner.close();
					return Integer.parseInt(answer);
				}
}catch (Exception e) {
	
}
		} while (sp == true);
		scanner.close();
		

		return 0;
		
	}

	public static boolean stepPlayer() {

		String choose = colorChoose();
		switch (choose) {
		case "blue":
System.out.println("Вы Выбрали синий!");
			break;
		case "yellow":
			System.out.println("Вы Выбрали желтый!");
			break;
		case "green":
			System.out.println("Вы Выбрали зеленый!");
			break;
		case "violet":
			System.out.println("Вы Выбрали фиолетовый!");
			break;

		default:
			break;
		}
		int count = countChoose(choose);
		System.out.println("Вы выбрали "+ count);
		count+=IkebaanaGo.ikebaana.get(choose);
		IkebaanaGo.ikebaana.put(choose, count);
		printIkebaana(IkebaanaGo.ikebaana);
		return true;
		
	}

	public static void printIkebaana(HashMap<String, Integer> ikebaana) {
		System.out.println(
				"Сейчас в Икебаане зеленых цветов - " + ikebaana.get("green") + " желтых - " + ikebaana.get("yellow")
						+ " синих - " + ikebaana.get("blue") + " фиолетовых -" + ikebaana.get("violet"));

	}

}