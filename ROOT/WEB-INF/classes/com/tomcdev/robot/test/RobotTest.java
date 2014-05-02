package com.tomcdev.robot.test;

import com.tomcdev.robot.om.Command;
import com.tomcdev.robot.om.Robot;
import com.tomcdev.robot.om.RobotPosition;

import junit.framework.TestCase;

public class RobotTest extends TestCase{

	public void testRobotObject(){
		Robot robot=new Robot();
		assertEquals (true,robot!=null);
	}
	public void testPlaceRobot(){
		String command="PLACE 0,0,NORTH";
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
		command.executeCommand(robot);
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
		command.executeCommand(robot);
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
		String commandString="REPORT";
		Command command=new Command(commandString);
		assertEquals(Command.REPORT,command.command);
	}
	
}
