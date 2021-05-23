package com.company;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
		Map<Integer, Integer> mapLixi = new HashMap<>();
		mapLixi.put(500000, 6);
		mapLixi.put(200000, 10);
		mapLixi.put(100000, 10);
		mapLixi.put(50000, 14);
		mapLixi.put(20000, 10);
		mapLixi.put(10000, 10);

		List<Integer> listMenhGia = new ArrayList<>(mapLixi.keySet());

		while (true){
			int totalMoney = mapLixi.entrySet().stream().map(a -> a.getKey() * a.getValue()).reduce(0, Integer::sum);
			DecimalFormat decimalFormat = new DecimalFormat();
			decimalFormat.applyPattern("###,###.## VND");
			System.out.println(decimalFormat.format(totalMoney));

			mapLixi.forEach((key, value) -> System.out.println("Menh Gia : " + key + ", So Luong : " + value));

			if(totalMoney <= 0){
				break;
			}

			System.out.print("Insert your name : ");
			String name = new Scanner(System.in).next();

			int random = getRandomNumber(0,listMenhGia.size() - 1);

			Integer menhGia = listMenhGia.get(random);

			System.out.println("Ban " + name + " da rut duoc to : " + decimalFormat.format(menhGia));

			System.out.println("------------------------------------------------------");

			mapLixi.put(menhGia,mapLixi.get(menhGia) - 1);

			if(mapLixi.get(menhGia) == 0){
				listMenhGia.remove(menhGia);
				mapLixi.remove(menhGia);
			}

		}



	}

	private static int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

}
