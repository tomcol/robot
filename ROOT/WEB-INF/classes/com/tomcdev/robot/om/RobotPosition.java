package com.tomcdev.robot.om;

public class RobotPosition {
	public Integer positionX=null;
	public Integer positionY=null;
	public String facing=null;
	public final static String NORTH="NORTH";
	public final static String SOUTH="SOUTH";
	public final static String EAST="EAST";
	public final static String WEST="WEST";
	
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
		return valid;
	}
	
	public void fromString(String postionString){
		String xString="";
		String yString="";
		String facingString="";
		String[] positionArr=postionString.split(",");
		try{
			xString=positionArr[0];
			positionX=Integer.parseInt(xString);
		}catch(Exception e){
		}
		try{
			yString=positionArr[1];
			positionY=Integer.parseInt(yString);
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			facingString=positionArr[2];
		}catch(Exception e){
			
		}
		if (facingString.equals(RobotPosition.NORTH)){
			facing=RobotPosition.NORTH;
		}
		if (facingString.equals(RobotPosition.EAST)){
			facing=RobotPosition.EAST;
		}
		if (facingString.equals(RobotPosition.WEST)){
			facing=RobotPosition.WEST;
		}
		if (facingString.equals(RobotPosition.SOUTH)){
			facing=RobotPosition.SOUTH;
		}
	}
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
	@Override
	public String toString(){
		if (isValid()){
			return positionX+","+positionY+","+facing;
		}
		return null;
	}
}
