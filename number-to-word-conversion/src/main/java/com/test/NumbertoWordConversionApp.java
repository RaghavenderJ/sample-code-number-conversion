package com.test;

import java.util.Scanner;

//Stand alone application which converts number into word
public class NumbertoWordConversionApp

{
	private static final String[] millionNames = { "", " thousand", " million" };

	private static final String[] digitNames = { "", " ten", " twenty",
			" thirty", " forty", " fifty", " sixty", " seventy", " eighty",
			" ninety" };

	private static final String[] numNames = { "", " one", " two", " three",
			" four", " five", " six", " seven", " eight", " nine", " ten",
			" eleven", " twelve", " thirteen", " fourteen", " fifteen",
			" sixteen", " seventeen", " eighteen", " nineteen" };


	
	public static void main(String[] args) {
		System.out.println("Enter your desired number :: ");
		NumbertoWordConversionApp appObject = null;
		try {			
			Scanner scanner = new Scanner(System.in);
			String number = scanner.nextLine();
			int num = Integer.parseInt(number);
			 if (num >= 0) {
				appObject = new NumbertoWordConversionApp();
				System.out.println("" + appObject.convertNumbertoWord(num));
			} else {
				System.out.println("Entered number is negative / Less than zero :" + num );
			}
		} catch (NumberFormatException e) {
			System.out.println("Please enter proper number " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	// This method returns the converted number to Word in String
	public String convertNumbertoWord(int number) {

		if (number == 0) {
			return "zero";
		}

		String prefix = "";
		String current = "";
		int tmp = 0;

		do {
			int n = number % 1000;
			if (n != 0) {
				String s = convertLessThousand(n);
				current = s + millionNames[tmp] + current;
			}
			tmp++;
			number /= 1000;
		} while (number > 0);

		return (prefix + current).trim();
	}
	
	
    //If any passed value is less than 1000 it returns converted string
	private String convertLessThousand(int number) {
		String current;

		if (number % 100 < 20) {
			current = numNames[number % 100];
			number /= 100;
		} else {
			current = numNames[number % 10];
			number /= 10;

			current = digitNames[number % 10] + current;
			number /= 10;
		}
		if (number == 0)
			return current;
		return numNames[number] + " hundred" + current;
	}
	
	
	
}
