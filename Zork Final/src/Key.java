/*
 * TODO: Create the class here, be sure to pay attention to the name of the file
 * also be sure to consider interfaces and abstract classes
 */
import java.util.*;
public class Key implements InventoryItem{


	
	/*
	TODO:  Create 3 instance variables:  name, description, weight, and roomIWorkIn
	be sure to select the most appropriate type for each
	Note: that weight can be a decimal
	*/
	private String name;
	private String description;
	private double weight;
	private ArrayList<String> roomIWorkIn;
	private ArrayList<String> direction;

	

	
	
	
	/**
	 * Key class constructor
	 * it builds a key with a name, description, and a weight of 0.2
	 * @param: a string to set the name of a Key ojbect
	 * @param: a string to set the description of a Key ojbect
	 */
	
	//TODO: make the Key constructor according to the description above
	
	public Key(String name, String description, String roomWorkIn, String direction){
		this.name = name;
		this.description = description;
		weight = 0.2;
		roomIWorkIn = new ArrayList<String>();
		roomIWorkIn.add(roomWorkIn);
		this.direction = new ArrayList<String>();
		this.direction.add(direction);
		
	}
	public Key(String name, String description, ArrayList<String> roomWorkIn, ArrayList<String> direction){
		this.name = name;
		this.description = description;
		weight = 0.2;
		this.roomIWorkIn = roomWorkIn;
		this.direction = direction;
		
	}

	
	
	/**
	 * Mutator method called "setName"
	 * 	This method is used to change the name of a Key ojbect
	 * 	@param: a String to update the name of a Key ojbect
	*/
	
	//TODO: make the setName method

	public void setName(String name){
		this.name = name;
	}


	
	/**
	 * 	Mutator method called "setDescription"
	 * 	This method is used to change the description of a Key ojbect
	 * 	@param: a String to update the description of a Key ojbect
	*/
	
	//TODO: make the setDescription method

	public void setDescription(String description){
		this.description = description;
	}



	/**
	 * Mutator method called "setWeight"
	 * This method is used to change the weight of a Key ojbect
	 * @param: a String to update the weight of a Key ojbect
	*/	
	
	//TODO: make the setWeight method

	public void setWeight(double weight){
		this.weight = weight;
	}


	
	/**
	 * Accessor method called "getName"
	 * This method is used to retrieve the name of a Key ojbect
	 * @return: a String that is the name of a Key ojbect
	*/
	
	//TODO: make the getName method
	public String getName(){
		return name;
	}



	/**
	 * Accessor method called "getDescription"
	 * This method is used to retrieve the description of a Key ojbect
	 * @return: a String that is the description of a Key ojbect
	*/	

	//TODO: make the getDescription method
	public String getDescription(){
		return description;
	}
	

	
	/**
	 * Accessor method called "getWeight"
	 * This method is used to retrieve the weight of a Key ojbect
	 * @return: a double that is the weight of a Key ojbect
	*/	

	//TODO: make the getWeight method

	public double getWeight(){
		return weight;
	}

	public ArrayList<String> getRoomWorkIn(){
		return roomIWorkIn;
	}
	public ArrayList<String> getDirection(){
		return direction;
	}
	/**
	 * Accessor method called "toString", overwrites the default toString method
	 * This method is used to retrieve all of the characteristics of a Key ojbect
	 * @return: a String that is all of the characteristics of a Key ojbect
	*/		
	
	//TODO: make the toString method

	public String toString(){
		return "Name: " + name + " Description: " + description + " Weight: " + weight;
	}




}