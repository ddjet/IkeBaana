package jet.ikebaana.controller;


import java.util.HashMap;
import java.util.Scanner;

import jet.ikebaana.model.IkebaanaMetods;

public class IkebaanaGo {
	public static HashMap<String, Integer> ikebaana = new HashMap<String, Integer>();
	

	public static void main(String[] args) {
	

	do {
		System.out.println("Играем!");
		game();
		System.out.println("играе"
				+ "м?");
		}while(IkebaanaMetods.check());
		System.out.println("До свидания");
		
	}

	private static void game() {
		System.out.println("Удачи!");
		ikebaana.put("blue", (int) (Math.random() * 4));
		ikebaana.put("yellow", (int) (Math.random() * 4));
		ikebaana.put("green", (int) (Math.random() * 4));
		ikebaana.put("violet", (int) (Math.random() * 4));
		IkebaanaMetods.printIkebaana(ikebaana);
		System.out.println("желаете ходить первым?");
		boolean firstStep = IkebaanaMetods.check();
		IkebaanaMetods.step(firstStep);
		}
	

}