package com.tomcdev.robot.test;

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
		RobotPosition position=new RobotPosition();
		position.fromString("0,0,NORTH");
		System.out.println(position.isValid());
		assertEquals ("0,0,NORTH",position.toString());
	}
	public void testNullRobotPosition(){
		String badPosition="6,6,balh";
		RobotPosition position=new RobotPosition();
		position.fromString(badPosition);
		assertEquals (false,position.isValid());
	}
	
}
