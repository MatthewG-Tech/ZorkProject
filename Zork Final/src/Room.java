//This is the solution file for the teacher reference

/*
 * Contains Checkpoint 4 Tasks 
 * 
 */
 
/*
 * TODO: import the utilities need to add an ArrayList
 */
import java.util.*;


/**
 * Room Class
 * Each room represents a spot in the world
 * Room's have names, descriptions, inventories, and 
 * passages or lack there of to the N,S,E, and W
 */
public class Room{

	//Informational: Fields for the Room class 
	
	private boolean canGoNorth;
	private boolean canGoSouth;
	private boolean canGoEast;
	private boolean canGoWest;
	private String description;
	private String name;

/*
 * TODO: Checkpoint 4 Task 
 * 
 * Add an instance variable that gives the Room an inventory
 * This is an ArrayList that only the Room can access
 * the type is InventoryItem.
 * Be sure to use encapsulation
 */
 
	private ArrayList<InventoryItem> inventory;
	
/**
 * default Room constructor
 * it populates all of the instance variables with default values of false for movement
 * it also adds a description that this is not actually a room
 */
	public Room(){
		this.canGoNorth = false;
		this.canGoSouth = false;
		this.canGoEast = false;
		this.canGoWest = false;
		this.name = "Not a room";
		this.description = "This is not a room, you shouldn't be here!!!";
	}
	
/**
 * custom Room constructor 
 * use to build an instance of a Room object 
 * the client populates all of the instance variables by
 * passing the following parameters in this order
 * 
 * @param canGoNorth
 * @param canGoSouth
 * @param canGoEast
 * @param canGoWest
 * @param name
 * @param description
 */
	public Room(boolean canGoNorth, boolean canGoEast, boolean canGoSouth, boolean canGoWest, String name, String description){
		this.canGoNorth = canGoNorth;
		this.canGoSouth = canGoSouth;
		this.canGoEast = canGoEast;
		this.canGoWest = canGoWest;
		this.name = name;
		this.description = description;
		
		
/*
 * TODO: Checkpoint 4 Task
 * 
 * initialize the inventory ArrayList
 */
		inventory = new ArrayList<InventoryItem>();
    
	}


	
/**
 * custom Room constructor with 7 parameters 
 * use to build an instance of a Room object 
 * the client populates all of the instance variables by
 * passing the following parameters in this order
 * 
 * @param canGoNorth
 * @param canGoSouth
 * @param canGoEast
 * @param canGoWest
 * @param name
 * @param description
 * @param item  -- this is type InventoryItem
 */
/*
 * TODO: Checkpoint 4 Task 
 * 
 * create the new Room constructor noted above
 * Hint: you can call the custom constructor above with the "this" key word
 * 
 */
	public Room(boolean canGoNorth, boolean canGoEast, boolean canGoSouth, boolean canGoWest, String name, String description, InventoryItem item){
		this.canGoNorth = canGoNorth;
		this.canGoSouth = canGoSouth;
		this.canGoEast = canGoEast;
		this.canGoWest = canGoWest;
		this.name = name;
		this.description = description;
		inventory = new ArrayList<InventoryItem>();
		inventory.add(item);
	}

/**
 * optional custom Room constructor with 7 parameters 
 * use to build an instance of a Room object 
 * the client populates all of the instance variables by
 * passing the following parameters in this order
 * 
 * @param canGoNorth
 * @param canGoSouth
 * @param canGoEast
 * @param canGoWest
 * @param name
 * @param description
 * @param item  -- this is an ArrayList of type InventoryItem
 */
/*
 * TODO: Checkpoint 4 Optional Task
 * 
 * create the optional constructor as noted above
 */
 
	public Room(boolean canGoNorth, boolean canGoEast, boolean canGoSouth, boolean canGoWest, String name, String description, ArrayList<InventoryItem> items){
		this.canGoNorth = canGoNorth;
		this.canGoSouth = canGoSouth;
		this.canGoEast = canGoEast;
		this.canGoWest = canGoWest;
		this.name = name;
		this.description = description;
		inventory = new ArrayList<InventoryItem>();
		for(int i = 0; i < items.size(); i++){	
			inventory.add(items.get(i));
		}
	}
	
	
	
 
 
 
/**
 * getDescription accessor method
 * gets the room description
 * @return the description
 */

	public String getDescription(){
		return this.description;
	}
	
/**
 * getName accessor method
 * It gets the room name
 * @return the name
 */

	public String getName(){
		return this.name;
	}
	
/**
 * setDescription mutator method
 * It sets the room description
 * @param d is the description of the room
 */

	public void setDescription(String d){
		description = d;
	}
	
/**
 * setName mutator method
 * It sets the room name
 * @param n is the name you want the room to have
 */

	public void setName(String n){
		name = n;
	}
	
	
/**
 * getCanGoNorth accessor method
 * used to determine if the player can move North
 * @return the value of canGoNorth
 */

	public boolean getCanGoNorth(){
		return this.canGoNorth;
	}
	
/**
 * getCanGoSouth accessor method
 * used to determine if the player can move South
 * @return the value of canGoSouth
 */

	public boolean getCanGoSouth(){
		return this.canGoSouth;
	}
	
/**
 * getCanGoEast accessor method
 * used to determine if the player can move East
 * @return the value of canGoEast
 */

	public boolean getCanGoEast(){
		return this.canGoEast;
	}
	
/**
 * getCanGoWest accessor method
 * used to determine if the player can move West
 * @return the value of canGoWest
 */

	public boolean getCanGoWest(){
		return this.canGoWest;
	}
	
/**
 * setCanGoNorth mutator method
 * used to update if the player can move North
 * @param a value to change the canGoNorth field
 */

	public void setCanGoNorth(boolean b){
		this.canGoNorth = b;
		
	}

/**
 * setCanGoSouth mutator method
 * used to update if the player can move South
 * @param a value to change the canGoSouth field
 */

	public void setCanGoSouth(boolean b){
		this.canGoSouth = b;
		
	}
	
/**
 * setCanGoEast mutator method
 * used to update if the player can move East
 * @param a value to change the canGoEast field
 */

	public void setCanGoEast(boolean b){
		this.canGoEast = b;
		
	}
	
/**
 * setCanGoWest mutator method
 * used to update if the player can move West
 * @param a value to change the canGoWest field
 */

	public void setCanGoWest(boolean b){
		this.canGoWest = b;		
	}
	
/**
 * toString accessor method
 * used to retrieve the state of the room you are in
 * 
 * example output: 
 * Kitchen 
 * A room with a table and fridge  
 * GoNorth: True GoSouth:False GoEast: True GoWest: True
 * 
 * @return a String with the Room Name, Description, and the ability to move each direction 
 */
	public String toString(){
		return name + "\n" + description + "\nGoNorth: " + canGoNorth + " Go South: " + canGoSouth + " Go East: " + canGoEast + " Go West: " +canGoWest;
	}
	


/**
 * hasObject accessor method
 * uses a String to search through the objects in the Room to 
 * determine if the object is present
 * 
 * @param objectName - a String that is the name of the object
 * @return a boolean that is true if the object is in the Room
 *         and false if it is not
 */
/* 
 * TODO: Checkpoint 4 Task
 * make the hasObject method
 *  
 */
 
	public boolean hasObject(String objectName){
		for(int i  = 0; i < inventory.size(); i++){
			//System.out.println(inventory.get(i).getName());
			//System.out.println(objectName);
			if(inventory.get(i).getName().toLowerCase().equals(objectName.toLowerCase())){
				//System.out.println("Return true");
				return true;
			}
		}
		return false;
	}
	
	
	public double getObjectWeight(String objectName){
		for(int i  = 0; i < inventory.size(); i++){
			//System.out.println(inventory.get(i).getName());
			//System.out.println(objectName);
			if(inventory.get(i).getName().toLowerCase().equals(objectName.toLowerCase())){
				
				return inventory.get(i).getWeight();
			}
		}
		return 0.0;
	}
	
	
	
 
 
  /**
   * addObject mutator method
   * used to pass an Object to the room 
   * 
   * @param invObject - a InventoryItem object to be added to the room inventory
   */
  /* 
   * TODO: Checkpoint 4 Task
   * make the addObject method
   *  
   */
	public void addObject(InventoryItem invObject){
		inventory.add(invObject);
	}

	
	
	
	
	
	
		
/**
 * removeObject mutator method
 * used to remove an Object from the room and
 * pass it to the client code 
 * 
 * @param objName - a String that is the name of the object to pull from the room
 * @return an InventoryItem object that is the object to be pulled from the room
 * 
 */
/* 
 * TODO: Checkpoint 4 Task
 * make the removeObject method
 *  
 */
	public InventoryItem removeObject(String invObject){
		for(int i  = 0; i < inventory.size(); i++){
			if(inventory.get(i).getName().toLowerCase().equals(invObject)){
				InventoryItem temp = inventory.get(i);
				inventory.remove(i);
				return temp;
			}
		}
		return null;
	}
	

	
	
	
	
	
	
	
	

/**
 * getNamesOfObjectsInRoom accessor method
 * used to get the names of all of the Objects in the Room inventory
 * 
 * @return returns "Items in room are : " followed by the items in the room. 
 *         If not items are in the room, then return "No items are in the room"
 */
/* 
 * TODO: Checkpoint 4 Task
 * make the getNamesOfObjectsInRoom method
 *  
 */	

	public String getNamesOfObjectsInRoom(){
		if(inventory.size() == 0){
			return "No items are in the room ";
		}
		String temp = "Items in room are :";
		for(int i = 0; i < inventory.size(); i++){
			if(i == inventory.size()-1){
				temp += " "+inventory.get(i).getName();
			}else{
				temp += " "+inventory.get(i).getName()+",";
			}
		}
		return temp;
	}
	
	
	
	public InventoryItem findOpenPot(){
		for(int i  = 0; i < inventory.size(); i++){
			//System.out.println("Groing thorugh");
			if(inventory.get(i).getName().toLowerCase().equals("garden pot")){
				//System.out.println("First if");
				InventoryItem temp = inventory.get(i);
				//System.out.println(temp instanceof gardenItem);
				if(temp instanceof gardenItem){
					//System.out.println("second if");
					if(!(((gardenItem)(inventory.get(i))).isGrowing())){
						//System.out.println("third lift");
						return temp;
					}
				}
			}
		}
		//System.out.println("null");
		return null;
	}
	public InventoryItem findPlantedPot(String name){
		for(int i  = 0; i < inventory.size(); i++){
			//System.out.println("Groing thorugh");
			if(inventory.get(i).getName().toLowerCase().equals(name + " plant")){
				//System.out.println("First if");
				InventoryItem temp = inventory.get(i);
				//System.out.println(temp instanceof gardenItem);
				if(temp instanceof gardenItem){
					//System.out.println("second if");
					if((((gardenItem)(inventory.get(i))).isGrowing())){
						//System.out.println("third lift");
						return temp;
					}
				}
			}
		}
		//System.out.println("null");
		return null;
	}
	
	
	
	
	
	
}
