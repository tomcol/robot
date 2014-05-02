package com.tomcdev.robot.om;

public class Command {

	String commandString="";
	
	public String command=null;
	
	RobotPosition position;
	
	public static final String PLACE="PLACE";
	public static final String MOVE="MOVE";
	public static final String LEFT="LEFT";
	public static final String RIGHT="RIGHT";
	public static final String REPORT="REPORT";
	
	public Command(String commandString){
		this.commandString=commandString;
		if (commandString.startsWith(Command.PLACE)){
			command=Command.PLACE;
			//parse position part;
		}
		if (commandString.startsWith(Command.MOVE)){
			command=Command.MOVE;
		}
		if (commandString.startsWith(Command.LEFT)){
			command=Command.LEFT;
		}
		if (commandString.startsWith(Command.RIGHT)){
			command=Command.RIGHT;
		}
		if (commandString.startsWith(Command.REPORT)){
			command=Command.REPORT;
		}
	}
	public boolean isValid(){
		return true;
	}
	public void executeCommand(RobotPosition position){
		
	}
	
	
}
