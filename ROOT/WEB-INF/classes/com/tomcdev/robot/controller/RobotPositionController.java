package com.tomcdev.robot.controller;

import com.tomcdev.robot.om.RobotPosition;

public class RobotPositionController {
	/*public void moveNorth(){
		if (positionY<4){
			positionY++;
		}
	}
	public void moveSouth(){
		if (positionY>0){
			positionY--;
		}
	}
	public void moveEast(){
		if (positionX<4){
			positionX++;
		}
	}
	public void moveWest(){
		if (positionX>0){
			positionX--;
		}
	}*/
	public static RobotPosition moveNorth(RobotPosition position){
		if (position.isValid() && position.getPositionY()<4){
			RobotPosition newPosition=new RobotPosition(position.getPositionX(),position.getPositionY()+1,position.getFacing());
			return newPosition;
		}
		return position;
	}
	
	
}
