package com.tomcdev.robot.test;

import com.tomcdev.robot.om.Robot;

import junit.framework.TestCase;

public class RobotTest extends TestCase{

	public void testRobotObject(){
		Robot robot=new Robot();
		assertEquals (true,robot!=null);
	}
	
}
