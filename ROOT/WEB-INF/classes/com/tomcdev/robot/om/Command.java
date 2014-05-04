package com.tomcdev.robot.om;

import com.tomcdev.robot.controller.RobotPositionController;

public class Command {
	
	private final String command;
	
	private final RobotPosition position;
	
	public static final String PLACE="PLACE";
	public static final String MOVE="MOVE";
	public static final String LEFT="LEFT";
	public static final String RIGHT="RIGHT";
	public static final String REPORT="REPORT";
	
	public Command(String commandString){
		if (commandString.startsWith(Command.PLACE)){
			command=Command.PLACE;
			String positionString=commandString.substring(6).trim();
			position=new RobotPosition(positionString);
		}else if(commandString.startsWith(Command.MOVE)){
			command=Command.MOVE;
			position=null;
		}else if(commandString.startsWith(Command.LEFT)){
			command=Command.LEFT;
			position=null;
		}else if(commandString.startsWith(Command.RIGHT)){
			command=Command.RIGHT;
			position=null;
		}else if(commandString.startsWith(Command.REPORT)){
			command=Command.REPORT;
			position=null;
		}else{
			commandString="";
			command=null;
			position=null;
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
				if (robot.position.getFacing().equals(RobotPosition.NORTH)){
					robot.position=RobotPositionController.moveNorth(robot.position);
				}
				if (robot.position.getFacing().equals(RobotPosition.SOUTH)){
					robot.position=RobotPositionController.moveSouth(robot.position);
				}
				if (robot.position.getFacing().equals(RobotPosition.EAST)){
					robot.position=RobotPositionController.moveEast(robot.position);
				}
				if (robot.position.getFacing().equals(RobotPosition.WEST)){
					robot.position=RobotPositionController.moveWest(robot.position);
				}
			}
			if (command.equals(Command.LEFT) && robot.getPosition()!=null && robot.getPosition().isValid()){
				robot.position=RobotPositionController.rotateLeft(robot.position);
			}
			if (command.equals(Command.RIGHT) && robot.getPosition()!=null && robot.getPosition().isValid()){
				robot.position=RobotPositionController.rotateRight(robot.position);
			}
		}
	}
	public String getCommand() {
		return command;
	}
	public RobotPosition getPosition() {
		return position;
	}
	
	
}
