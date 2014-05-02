package com.tomcdev.robot;

import java.util.Scanner;

public class RunRobot {
	public static void main ( String [] args ){
		Scanner scanner = new Scanner( System.in );
		System.out.print( "Type some data for the program: " );
		String input = scanner.nextLine();
		System.out.println( "input = " + input );
	}
}
