package com.tomcdev.robot.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.tomcdev.robot.om.Command;
import com.tomcdev.robot.om.Robot;
import com.tomcdev.robot.om.RobotPosition;

import junit.framework.TestCase;

public class RobotTest extends TestCase{
	ByteArrayOutputStream baos;
	PrintStream old;
	public void testRobotObject(){
		Robot robot=new Robot();
		assertEquals (true,robot!=null);
	}
	public void testPlaceRobot(){
		RobotPosition position=new RobotPosition("0,0,NORTH");
		assertEquals ("0,0,NORTH",position.toString());
	}
	public void testPlaceCommand(){
		String commandString="PLACE 0,0,NORTH";
		Command command=new Command(commandString);
		assertEquals(commandString,"PLACE "+command.position);
	}
	public void testExecutePlaceCommand(){
		Robot robot=new Robot();
		String commandString="PLACE 0,0,NORTH";
		Command command=new Command(commandString);
		command.executeCommand(robot);
		assertEquals("0,0,NORTH",robot.position.toString());
	}
	public void testExecuteReportCommand(){
		Robot robot=new Robot();
		String commandString="PLACE 0,0,NORTH";
		Command command=new Command(commandString);
		command.executeCommand(robot);
		commandString="REPORT";
		command=new Command(commandString);
		redirectOutput();
		command.executeCommand(robot);
		resetOutput();
		assertEquals("0,0,NORTH",baos.toString().trim());
	}
	public void testEdgeOfTable(){
		Robot robot=new Robot();
		String commandString="PLACE 0,0,NORTH";
		Command command=new Command(commandString);
		command.executeCommand(robot);
		commandString="MOVE";
		command=new Command(commandString);
		command.executeCommand(robot);
		commandString="MOVE";
		command=new Command(commandString);
		command.executeCommand(robot);
		commandString="MOVE";
		command=new Command(commandString);
		command.executeCommand(robot);
		commandString="MOVE";
		command=new Command(commandString);
		command.executeCommand(robot);
		commandString="MOVE";
		command=new Command(commandString);
		command.executeCommand(robot);
		commandString="REPORT";
		command=new Command(commandString);
		this.redirectOutput();
		command.executeCommand(robot);
		this.redirectOutput();
		assertEquals(true,robot.position.isValid());
	}
	public void testLeft(){
		Robot robot=new Robot();
		String commandString="PLACE 0,0,NORTH";
		Command command=new Command(commandString);
		command.executeCommand(robot);
		commandString="LEFT";
		command=new Command(commandString);
		command.executeCommand(robot);
		assertEquals(RobotPosition.WEST,robot.position.getFacing().toString());
		
	}
	public void testRight(){
		Robot robot=new Robot();
		String commandString="PLACE 0,0,NORTH";
		Command command=new Command(commandString);
		command.executeCommand(robot);
		commandString="RIGHT";
		command=new Command(commandString);
		command.executeCommand(robot);
		assertEquals(RobotPosition.EAST,robot.position.getFacing().toString());
		
	}
	public void testNullRobotPosition(){
		String badPosition="6,6,balh";
		RobotPosition position=new RobotPosition(badPosition);
		assertEquals (false,position.isValid());
	}
	public void testMove(){
		Robot robot=new Robot();
		String commandString="PLACE 0,0,NORTH";
		Command command=new Command(commandString);
		command.executeCommand(robot);
		commandString="MOVE";
		command=new Command(commandString);
		command.executeCommand(robot);
		assertEquals("0,1,NORTH",robot.position.toString());
	}
	public void testMoveEast(){
		Robot robot=new Robot();
		String commandString="PLACE 0,0,EAST";
		Command command=new Command(commandString);
		command.executeCommand(robot);
		commandString="MOVE";
		command=new Command(commandString);
		command.executeCommand(robot);
		assertEquals("1,0,EAST",robot.position.toString());
	}
	public void testCommandLeft(){
		String commandString="LEFT";
		Command command=new Command(commandString);
		assertEquals(Command.LEFT,command.command);
	}
	public void testCommandRight(){
		String commandString="RIGHT";
		Command command=new Command(commandString);
		assertEquals(Command.RIGHT,command.command);
	}
	public void testCommandReport(){
		Robot robot=new Robot();
		String commandString="PLACE 0,0,NORTH";
		Command command=new Command(commandString);
		command.executeCommand(robot);
		commandString="REPORT";
		redirectOutput();
		command=new Command(commandString);
		command.executeCommand(robot);
		resetOutput();
		assertEquals("0,0,NORTH",baos.toString().trim());
	}
	public void testCommandsText(){
		Robot robot=new Robot();
		String commands="PLACE 1,2,EAST\n";
		commands+="MOVE\n";
		commands+="MOVE\n";
		commands+="LEFT\n";
		commands+="MOVE\n";
		commands+="REPORT";
		String[] commandsArr=commands.split("\n");
		int i=0;
		redirectOutput();
		while (i<commandsArr.length){
			String commandString=commandsArr[i];
			Command command=new Command(commandString);
			command.executeCommand(robot);
			i++;
		}
		resetOutput();
	    assertEquals("3,3,NORTH",baos.toString().trim());
	}
	public void redirectOutput(){
		baos = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(baos);
	    old = System.out;
		System.setOut(ps);
	}
	public void resetOutput(){
		System.out.flush();
	    System.setOut(old);
	}
}
