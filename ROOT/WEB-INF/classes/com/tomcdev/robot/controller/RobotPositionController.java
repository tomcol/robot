package com.tomcdev.robot.controller;

import com.tomcdev.robot.om.RobotPosition;

public class RobotPositionController {
	public static RobotPosition moveNorth(RobotPosition position){
		if (position.isValid() && position.getPositionY()<4){
			RobotPosition newPosition=new RobotPosition(position.getPositionX(),position.getPositionY()+1,position.getFacing());
			return newPosition;
		}
		return position;
	}
	public static RobotPosition moveSouth(RobotPosition position){
		if (position.isValid() && position.getPositionY()>0){
			RobotPosition newPosition=new RobotPosition(position.getPositionX(),position.getPositionY()-1,position.getFacing());
			return newPosition;
		}
		return position;
	}
	public static RobotPosition moveEast(RobotPosition position){
		if (position.isValid() && position.getPositionX()<4){
			RobotPosition newPosition=new RobotPosition(position.getPositionX()+1,position.getPositionY(),position.getFacing());
			return newPosition;
		}
		return position;
	}
	public static RobotPosition moveWest(RobotPosition position){
		if (position.isValid() && position.getPositionX()>0){
			RobotPosition newPosition=new RobotPosition(position.getPositionX()-1,position.getPositionY(),position.getFacing());
			return newPosition;
		}
		return position;
	}
	public static RobotPosition rotateLeft(RobotPosition position){
		if (position.getFacing().equals(RobotPosition.EAST)){
			RobotPosition newPosition=new RobotPosition(position.getPositionX(),position.getPositionY(),RobotPosition.NORTH);
			return newPosition;
		}
		if (position.getFacing().equals(RobotPosition.NORTH)){
			RobotPosition newPosition=new RobotPosition(position.getPositionX(),position.getPositionY(),RobotPosition.WEST);
			return newPosition;
		}
		if (position.getFacing().equals(RobotPosition.WEST)){
			RobotPosition newPosition=new RobotPosition(position.getPositionX(),position.getPositionY(),RobotPosition.SOUTH);
			return newPosition;
		}
		if (position.getFacing().equals(RobotPosition.SOUTH)){
			RobotPosition newPosition=new RobotPosition(position.getPositionX(),position.getPositionY(),RobotPosition.EAST);
			return newPosition;
		}
		return position;
	}
	public static RobotPosition rotateRight(RobotPosition position){
		if (position.getFacing().equals(RobotPosition.EAST)){
			RobotPosition newPosition=new RobotPosition(position.getPositionX(),position.getPositionY(),RobotPosition.SOUTH);
			return newPosition;
		}
		if (position.getFacing().equals(RobotPosition.NORTH)){
			RobotPosition newPosition=new RobotPosition(position.getPositionX(),position.getPositionY(),RobotPosition.EAST);
			return newPosition;
		}
		if (position.getFacing().equals(RobotPosition.WEST)){
			RobotPosition newPosition=new RobotPosition(position.getPositionX(),position.getPositionY(),RobotPosition.NORTH);
			return newPosition;
		}
		if (position.getFacing().equals(RobotPosition.SOUTH)){
			RobotPosition newPosition=new RobotPosition(position.getPositionX(),position.getPositionY(),RobotPosition.WEST);
			return newPosition;
		}
		return position;
	}
}
