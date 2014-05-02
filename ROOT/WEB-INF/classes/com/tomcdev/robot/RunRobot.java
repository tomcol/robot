package com.tomcdev.robot;

import java.util.Scanner;

import com.tomcdev.robot.om.Command;
import com.tomcdev.robot.om.Robot;

public class RunRobot {
	public static void main ( String [] args ){
		Robot robot=new Robot();
		Scanner scanner = new Scanner( System.in );
		while (true==true){
			System.out.print( "Enter Command: " );
			String commandString = scanner.nextLine();
			Command command=new Command(commandString);
			if (!command.isValid()){
				System.out.println(commandString+" : COMMAND NOT VALID");
			}else{
				command.executeCommand(robot);
			}
		}
	}
}
