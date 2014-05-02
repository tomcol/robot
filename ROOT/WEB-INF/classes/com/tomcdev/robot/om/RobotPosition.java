package com.tomcdev.robot.om;

public class RobotPosition {
	private final Integer positionX;
	private final Integer positionY;
	private final String facing;
	public final static String NORTH="NORTH";
	public final static String SOUTH="SOUTH";
	public final static String EAST="EAST";
	public final static String WEST="WEST";
	
	public RobotPosition(String postionString){
		String xString="";
		String yString="";
		String facingString="";
		String[] positionArr=postionString.split(",");
		if (positionArr.length==3){
			xString=positionArr[0];
			yString=positionArr[1];
			facingString=positionArr[2];
			positionY=Integer.parseInt(yString);
			positionX=Integer.parseInt(xString);
			if (facingString.equals(RobotPosition.NORTH)){
				facing=RobotPosition.NORTH;
			}else if(facingString.equals(RobotPosition.EAST)){
				facing=RobotPosition.EAST;
			}else if(facingString.equals(RobotPosition.WEST)){
				facing=RobotPosition.WEST;
			}else if(facingString.equals(RobotPosition.SOUTH)){
				facing=RobotPosition.SOUTH;
			}else{
				facing=null;
			}
		}else{
			positionX=null;
			positionY=null;
			facing=null;
		}
	}
	public RobotPosition(Integer positionX,Integer positionY,String facing){
		this.positionX=positionX;
		this.positionY=positionY;
		this.facing=facing;
	}
	public boolean isValid(){
		boolean valid=true;
		if (positionX==null || positionX<0 || positionX>4){
			valid=false;
		}
		if (positionY==null || positionY<0 || positionY>4){
			valid=false;
		}
		if (facing==null){
			valid=false;
		}
		if (facing!=RobotPosition.SOUTH && facing!=RobotPosition.NORTH && facing!=RobotPosition.WEST && facing!=RobotPosition.EAST){
			valid=false;
		}
		return valid;
	}
	
	/*
	public void moveNorth(){
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
	}
	public void rotateLeft(){
		if (facing.equals(RobotPosition.EAST)){
			facing=RobotPosition.NORTH;
			return;
		}
		if (facing.equals(RobotPosition.NORTH)){
			facing=RobotPosition.WEST;
			return;
		}
		if (facing.equals(RobotPosition.WEST)){
			facing=RobotPosition.SOUTH;
			return;
		}
		if (facing.equals(RobotPosition.SOUTH)){
			facing=RobotPosition.EAST;
			return;
		}
	}
	public void rotateRight(){
		if (facing.equals(RobotPosition.EAST)){
			facing=RobotPosition.SOUTH;
			return;
		}
		if (facing.equals(RobotPosition.NORTH)){
			facing=RobotPosition.EAST;
			return;
		}
		if (facing.equals(RobotPosition.WEST)){
			facing=RobotPosition.NORTH;
			return;
		}
		if (facing.equals(RobotPosition.SOUTH)){
			facing=RobotPosition.WEST;
			return;
		}
	}
	*/
	public Integer getPositionX() {
		return positionX;
	}
	public Integer getPositionY() {
		return positionY;
	}
	public String getFacing() {
		return facing;
	}
	@Override
	public String toString(){
		if (isValid()){
			return positionX+","+positionY+","+facing;
		}
		return null;
	}
}
