package com.tomcdev.robot.om;

public class Command {

	String commandString="";
	
	public String command=null;
	
	public RobotPosition position;
	
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
		if (command.equals(Command.PLACE)){
			String positionString=commandString.substring(6).trim();
			position=new RobotPosition();
			position.fromString(positionString);
		}
	}
	public boolean isValid(){
		if (command==null){
			return false;
		}
		return true;
	}
	public void executeCommand(Robot robot){
		if (isValid()){
			if (command.equals(Command.PLACE)){
				robot.position=this.position;
			}
			if (command.equals(Command.REPORT) && robot.getPosition()!=null && robot.getPosition().isValid()){
				System.out.println(robot.position);
			}
			if (command.equals(Command.MOVE) && robot.getPosition()!=null && robot.getPosition().isValid()){
				if (robot.position.facing.equals(RobotPosition.NORTH)){
					robot.position.moveNorth();
				}
				if (robot.position.facing.equals(RobotPosition.SOUTH)){
					robot.position.moveSouth();
				}
				if (robot.position.facing.equals(RobotPosition.EAST)){
					robot.position.moveEast();
				}
				if (robot.position.facing.equals(RobotPosition.WEST)){
					robot.position.moveWest();
				}
			}
			if (command.equals(Command.LEFT) && robot.getPosition()!=null && robot.getPosition().isValid()){
				robot.position.rotateLeft();
			}
		}
	}
	
	
}
